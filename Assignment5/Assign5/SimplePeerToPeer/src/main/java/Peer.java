
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import org.json.*;

/**
 * This is the main class for the peer-to-peer program.
 * It starts a client with a username and port. Next, the peer can decide who to listen to.
 * This peer-to-peer application is a subscriber model, where we can broadcast messages to anyone who wants to listen
 * and also choose who to listen to.
 */
public class Peer {
    private String username;
    private BufferedReader bufferedReader;
    private ServerThread serverThread;
    ArrayList<Integer> ports = new ArrayList<Integer>();

    public Peer(BufferedReader bufReader, String username, ServerThread serverThread) {
        this.username = username;
        this.bufferedReader = bufReader;
        this.serverThread = serverThread;
    }

    /**
     * Main method to start the peer-to-peer application.
     *
     * @param args [0] username, [1] port for server
     */
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String username = args[0];

        if (Integer.valueOf(args[1]) > 9009 || Integer.valueOf(args[1]) < 9000) {
            System.out.println("Sorry, the port number must be between 9000 and 9010!");
            System.exit(0);
        }

        System.out.println("Hello " + username + " and welcome! Your port will be " + args[1]);

        // Starting the Server Thread, which waits for other peers to connect
        ServerThread serverThread = new ServerThread(args[1]);
        serverThread.start();

        // Creating the Peer instance
        Peer peer = new Peer(bufferedReader, args[0], serverThread);

        // Update the list of peers to listen to
        peer.updateListenToPeers(args[1]);
    }

    public void scanPorts() throws Exception {
        for (int x = 9000; x < 9011; x++) {
            if (!ports.contains(x))
                try {
                    //System.out.println(serverThread.getPortNumber() + " attempting to connect to port " + x);
                    Socket socket = new Socket("localhost", x);
                    new ClientThread(socket).start();
                    ports.add(x);
                    x = 9011;
                } catch (Exception e) {
                }
        }
        System.out.println("Ports connected to: " + ports.toString());
    }

    public void updateListenToPeers(String port) throws Exception {
        if (!ports.contains(Integer.valueOf(port)))
            ports.add(Integer.valueOf(port));
        for (int x = 9000; x < 9010; x++) {
            if (!ports.contains(x))
                try {
                    Socket socket = new Socket("localhost", x);
                    new ClientThread(socket).start();
                    ports.add(x);
                } catch (Exception e) {
                    if (e.getMessage().contains("Address already in use")) {
                        serverThread.restartServer(port);
                    }
                }
        }
        System.out.println("Ports connected to: " + ports.toString());

        askForInput();
    }

    /**
     * Waits for user input to send messages or exit the application.
     */
    public void askForInput() throws Exception {
        try {
            System.out.println(" You can now start chatting (type 'exit' to exit) ");
			            while (true) {
                String message = bufferedReader.readLine();

                if (message.equals("exit")) {
                    System.out.println("Bye! See you next time.");
					serverThread.sendMessage("{'username': '" + username + "','message':'" + message + "'}");
					break;
                } else {
                    // Sending the message to the server thread, which will broadcast it to listening peers
                    serverThread.sendMessage("{'username': '" + username + "','message':'" + message + "'}");
                }

                if (serverThread.scanTime()) {
                    System.out.println("[System]: New member joining, please wait while they are added.");
                    scanPorts();
                    System.out.println("> You can now start chatting (type 'exit' to exit)");
                }
            }
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	
}

