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

            // Starts threads using specific classes for asynchronous connection.
			new SendMessages(clientSocket).start();
			new ReceiveMessages(clientSocket).start();
        } catch (IOException e) {
            System.out.println("Socket creation failed: " + e);
        }
    }
}
