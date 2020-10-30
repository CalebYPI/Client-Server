/* SimpleClient.java
   This is the client program
   Author: Kruben Naidoo
   Date: 15 September 2020 */

package simpleclient;

import java.net.*;
import java.io.*;

public class SimpleClient {
    public static void main(String args[]) {
        try {
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
            System.out.println(dis.readUTF());

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
    }
}
			