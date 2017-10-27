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
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("HELO");

            // Reads from the server.
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            System.out.println("Socket creation failed.");
        }
    }
}
