package mainFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import valueObject.VLogin;

public class PLogin {
	public static void main(String[] args) {
        String serverAddress = "localhost"; 
        int port = 12345; 

        try {
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Connected to the server.");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String userInputLine;
            System.out.println("Enter a message (type 'exit' to quit):");

            while ((userInputLine = userInput.readLine()) != null) {
                out.println(userInputLine);
                System.out.println("Server response: " + in.readLine()); 

                if (userInputLine.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            in.close();
            out.close();
            socket.close();
            System.out.println("Disconnected from the server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	public boolean validateUser(VLogin vLogin) {
		boolean bResult = true;
		
		
		return bResult;
	}
	
}
