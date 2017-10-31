import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class SendMessages
{
    public void writeMessage(Socket clientSocket, String message)
    {
        try
        {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(message);
        } catch (IOException e) {
            System.out.println("Message not sent");
        }
    }
}
