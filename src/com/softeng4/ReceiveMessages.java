package com.softeng4;

import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class ReceiveMessages extends Thread
{
	Random rnd = new Random();
	
    public void getMessage(Socket clientSocket)
    {
		for(int i = 0; i < 30; i++)
		{
			System.out.println("Recieve: " + rnd.nextInt(100));
		}
        /* try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			String message;
			while((message = stdIn.readLine()) != null)
			{
				System.out.println(message);
			}
        } catch (IOException e)
        {
            System.out.println("Cannot reach response");
        } */
    }
}
