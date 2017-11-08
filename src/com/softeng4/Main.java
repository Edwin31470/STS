package com.softeng4;

import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class Main
{
    public static void main (String[] args)
    {
        String hostName = args[0];
        try {
            // Creates socket with imported host name.
            Socket clientSocket = new Socket(hostName, 5000);
            System.out.println("Socket creation succeeded.");
			
			// Send messages to server
			SendMessages message = new SendMessages();
			ReceiveMessages response = new ReceiveMessages();
			
			Thread sendThread = new Thread(message);
			Thread getThread = new Thread(response);

			getThread.start();
			sendThread.start();
            
			message.writeMessage(clientSocket);
			response.getMessage(clientSocket);
			
			clientSocket.close();
        } catch (IOException e) {
            System.out.println("Socket creation failed: " + e);
        }
    }
}
