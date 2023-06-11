package Assign32starter;
import java.net.*;
import java.io.*;

public class SockServerGui {
    public static void main (String args[]) {
        Socket sock;
        try {
            try (ServerSocket serv = new ServerSocket(8888)) {
                System.out.println("Server ready for 3 connections");

                for (int rep = 0; rep < 3; rep++){
                    System.out.println("Server waiting for a connection");
                    sock = serv.accept(); 
                    ObjectInputStream in = new ObjectInputStream(sock.getInputStream());

                    String s = (String) in.readObject();
                    System.out.println("Received the String "+s);
                    Integer i = (Integer) in.readObject();
                    System.out.println("Received the Integer "+ i);


                    OutputStream out = sock.getOutputStream();
                    ObjectOutputStream os = new ObjectOutputStream(out);
                    os.writeObject("Got it!");
                    os.flush();
                }
            }
        } catch(Exception e) {e.printStackTrace();}
    }
}
