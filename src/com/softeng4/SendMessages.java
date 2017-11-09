package com.softeng4;

import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class SendMessages extends Thread
{
	Random rnd = new Random();
	Socket clientSocket;

	public SendMessages(Socket clientSocket)
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

            // Reads in commands until closing connection with server.
			boolean notDone = true;
			while(notDone)
			{
				System.out.println("Enter a command: ");
				String command = br.readLine();

				if (command.equals("EXIT"))
				{
					out.println(command);
					notDone = false;
					this.clientSocket.close();
				}
				else
				{
					out.println(command);
				}	
			}
        } catch (IOException e) {
            System.out.println("Send Message Error: " + e);
        }
    }
}