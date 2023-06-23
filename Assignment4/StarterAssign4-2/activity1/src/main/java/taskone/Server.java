
/**
  File: Server.java
  Author: Student in Fall 2020B
  Description: Server class in package taskone.
*/

package taskone;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONObject;

/**
 * Class: Server
 * Description: Server tasks.
 */
class Server {

    public static void main(String[] args) throws Exception {
        int port;
        StringList strings = new StringList();


        port = Integer.parseInt(args[0]);
        
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server Started...");
        while (true) {
            System.out.println("Accepting a Request...");
            Socket sock = server.accept();

            Performer performer = new Performer(sock, strings);
            performer.run();
            try {
                System.out.println("close socket of client ");
                sock.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}