package com.softeng4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class RequestUpdates extends Thread
{
	Socket clientSocket;

	public RequestUpdates(Socket clientSocket)
	{
		// Assigns clientSocket to internal variable.
		this.clientSocket = clientSocket;
	}

    public void run()
    {
        try
        {
            PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            // Reader for reading in commands through IntelliJ.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true)
			{
				this.sleep(15000);
				out.println("DISP:" + Main.clientID);
			}
        } catch (IOException e) {
            System.out.println("Send Message Error: " + e);
        } catch (InterruptedException e) {
			System.out.println("Wait error " + e);
		}
	}
}
