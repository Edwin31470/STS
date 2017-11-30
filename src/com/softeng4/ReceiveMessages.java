package com.softeng4;

import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class ReceiveMessages extends Thread
{
	static ReceiveMessages ref;

	Random rnd = new Random();

	Socket clientSocket;

	private ReceiveMessages(Socket clientSocket)
	{
		this.clientSocket = clientSocket;
	}

	public static ReceiveMessages GetInstance(Socket clientSocket)
	{
		if(ref == null)
		{
			ref = new ReceiveMessages(clientSocket);
		}
		return ref;
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
				if((message.length() > 13) && (message.substring(0,13).equals("REGI:SUCCESS:")))
				{
					String ID = message.substring(13);
					Main.clientID = ID;
					System.out.println(Main.clientID);
				}
			}
        } catch (IOException e)
        {
            System.out.println("Receive Message Error: " + e);
        }
    }
}
