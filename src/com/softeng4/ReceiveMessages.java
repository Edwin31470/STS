package com.softeng4;

import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class ReceiveMessages extends Thread
{
	Random rnd = new Random();

	Socket clientSocket;

	public ReceiveMessages(Socket clientSocket)
	{
		this.clientSocket = clientSocket;
	}

    public void run()
    {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            // Infinitely looks at the socket for messages.
			String message;
			while((message = in.readLine()) != null)
			{
				System.out.println(message);
			}
        } catch (IOException e)
        {
            System.out.println("Receive Message Error: " + e);
        }
    }
}
