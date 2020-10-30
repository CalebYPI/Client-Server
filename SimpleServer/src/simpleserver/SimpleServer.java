/* SimpleServer.java
   This is the server program
   Author: Kruben Naidoo
   Date: 15 September 2020 */

package simpleserver;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SimpleServer {
    public static void main(String args[]) {
        ServerSocket s = null;
        Scanner input = new Scanner(System.in);
        // Register your service on port 5432
        try {
            s = new ServerSocket(5432);
        } 
        catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
            System.exit(0);
        }

        // Run the listen/accept loop forever
        while (true) {try {
            // Open your connection to a server, at port 5433
            // localhost used here
            Socket s1 = new Socket("192.168.18.24", 5433);
            System.out.println("Connection established at port 5433");

            // Get an input stream from the socket
            InputStream is = s1.getInputStream();
            // Decorate it with a "data" input stream
            DataInputStream dis = new DataInputStream(is);
            System.out.println("Getting data...");

            // Read the input and print it to the screen
            System.out.println("\n"+dis.readUTF()+"\n");

            // When done, just close the stream and connection
            dis.close();
            s1.close();
            System.out.println("Connection closed.");
        }
        catch (ConnectException connExcep) {
            System.out.println("Error: " + connExcep.getMessage());
        }
        catch (IOException ioExcep) {
            System.out.println("Error: " + ioExcep.getMessage());    
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
            try {
                // Wait here and listen for a connection
                System.out.println("Server running...listening for a connection...");
                Socket s1 = s.accept();

                // Get output stream associated with the socket
                System.out.println("Connection established");
                OutputStream s1out = s1.getOutputStream();
                DataOutputStream dos = new DataOutputStream(s1out);

                // Send your string!
                System.out.println("Sending data...");
                
                dos.writeUTF("\n"+input.nextLine()+"\n");

                dos.flush();

                // Close the connection, but not the server socket
                dos.close();
                s1.close();
                System.out.println("Connection closed.");
            } 
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}