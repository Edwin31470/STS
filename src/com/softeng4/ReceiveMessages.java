package com.softeng4;

import com.sun.org.apache.bcel.internal.generic.GOTO;

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
				String[] splitMessage = message.split(":");
				if(splitMessage[0] == "REGI")
				{
					Main.clientID = splitMessage[2];
					System.out.println(Main.clientID);
				}
				else if(splitMessage[0] == "UPD")
				{
					boolean found = false;
					for (int i = 0; i < Main.theStocks.length; i++)
					{
						if (Main.theStocks[i].getName() == splitMessage[1])
						{
							found = true;
							Main.theStocks[i].setValue(splitMessage[2]);
							Main.theStocks[i].setNextChange(splitMessage[3]);
						}
					}
					boolean set = false;
					if (!found)
					{
						while (!set)
						{
							int cnt = 0;
							if (Main.theStocks[cnt] == null)
							{
								Main.theStocks[cnt] = new Stock();
								Main.theStocks[cnt].setName(splitMessage[1]);
								Main.theStocks[cnt].setValue(splitMessage[2]);
								Main.theStocks[cnt].setNextChange(splitMessage[3]);
								set = true;
							}
							cnt++;
						}
					}
				}
			}
        } catch (IOException e) {
			System.out.println("Receive Message Error: " + e);
		}
	}
}
