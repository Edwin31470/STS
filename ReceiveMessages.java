import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class ReceiveMessages
{
    public void getMessage(Socket clientSocket)
    {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e)
        {
            System.out.println("Cannot reach response");
        }
    }
}
