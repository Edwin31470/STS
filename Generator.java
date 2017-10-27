import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class Generator
{
    public static void main (String[] args)
    {
        String hostName = args[0];
        try {
            // Creates socket with imported host name.
            Socket clientSocket = new Socket(hostName, 5000);
            System.out.println("Socket creation succeeded.");

            // Writes to the server via the socket.
            SendMessages message = new SendMessages();
            message.writeMessage(clientSocket, "HELO");

            // Reads from the server.
            ReceiveMessages response = new ReceiveMessages();
            response.getMessage(clientSocket);
        } catch (IOException e) {
            System.out.println("Socket creation failed.");
        }
    }
}
