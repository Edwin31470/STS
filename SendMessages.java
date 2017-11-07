import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class SendMessages extends Thread
{
	Random rnd = new Random();
	
    public void writeMessage(Socket clientSocket)
    {
		for(int i = 0; i < 30; i++)
		{
			System.out.println("write: " + rnd.nextInt(100));
		}

        /* try
        {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			boolean notDone = true;
			while(notDone)
			{
				System.out.println("Enter a command: ");
				String command = System.console().readLine();

				if (command.equals("CLOSE"))
				{
					notDone = false;
				}
				else
				{
					out.println(command);
				}	
			}
        } catch (IOException e) {
            System.out.println("Message not sent");
        } */
    }
}
