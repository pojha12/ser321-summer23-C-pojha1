package Assign32starter;

import org.json.*;

import java.io.*;
import java.net.Socket;



public class Client {
    public static  void main(String args[]) throws IOException{

       // Scanner scanner = new Scanner(System.in);

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));


        try{
            if(args.length != 2){
                System.exit(0);
            }

            int port = -1;

            try{
                port = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e){
                System.out.println("Port must be a integer number!");
                System.exit(2);
            }

            String host = args[0];
            Socket sock = new Socket(host, port);
            System.out.println("Connected to server with IP: " + host + " at port: " + port);
            InputStream in = sock.getInputStream();
            OutputStream out = sock.getOutputStream();
            ObjectOutputStream oStream = new ObjectOutputStream(out);
            ObjectInputStream iStream = new ObjectInputStream(in);
            oStream.writeObject("{'type':'game'}");
            oStream.flush();

            loop: while(true){
                String servResponse = (String) iStream.readObject();
                JSONObject serverResponse = new JSONObject(servResponse);

                if(serverResponse.getBoolean("ok")){
                    if(serverResponse.getString("type").equals("game")){
                        System.out.println("Starting GUI");
                    }
                    else if(serverResponse.getString("type").equals("leader")){
                        System.out.println("Print Leaderboard");
                    }
                    else if(serverResponse.getString("type").equals("quit")){
                        System.out.println("Quit");
                        oStream.writeObject("{'type':'quit'}");
                        break loop;
                    }
                    else if(serverResponse.getString("type").equals("name")){
                        System.out.println("Getting Name");
                    }
                    else if(serverResponse.getString("type").equals("start")){
                        System.out.println("Starting Game");
                    }
                    else if(serverResponse.getString("type").equals("more")){
                        System.out.println("New Image");
                    }
                }
            }
            scanner.close();
            oStream.close();
            iStream.close();
            sock.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
