package com.softeng4;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class SendMessages extends Thread
{
	static SendMessages ref;
	Socket clientSocket;

	private SendMessages(Socket clientSocket)
	{
		// Assigns clientSocket to internal variable.
		this.clientSocket = clientSocket;
	}

	public static SendMessages GetInstance(Socket clientSocket)
	{
		if(ref == null)
		{
			ref = new SendMessages(clientSocket);
		}
		return ref;
	}

    public void run()
    {
        try
        {
            PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            // Reader for reading in commands through IntelliJ.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            out.println("HELO");
            out.println("REGI");

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
				else if (command.equals("DISP"))
				{
					for(int i = 0; i < Main.theStocks.length; i++)
					{
						Stock stock = Main.theStocks[i];
						System.out.println(stock.getName() + ":" + stock.getValue());

						for(int j = 0; j < 5; j++)
						{
							System.out.print(Main.theStocks[i].getChanges()[j]);
						}
					}

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
