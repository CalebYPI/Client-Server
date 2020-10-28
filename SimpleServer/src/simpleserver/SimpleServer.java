/* SimpleServer.java
   This is the server program
   Author: Kruben Naidoo
   Date: 15 September 2020 */

package simpleserver;

import java.net.*;
import java.io.*;

public class SimpleServer {
    public static void main(String args[]) {
        ServerSocket s = null;

        // Register your service on port 5432
        try {
            s = new ServerSocket(5432);
        } 
        catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
            System.exit(0);
        }

        // Run the listen/accept loop forever
        while (true) {
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
                dos.writeUTF("Hello Net World!");

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