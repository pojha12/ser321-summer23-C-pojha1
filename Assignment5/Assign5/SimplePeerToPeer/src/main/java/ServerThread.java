
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList; 

/**
 * SERVER
 * This is the ServerThread class that has a socket where we accept clients contacting us.
 * We save the clients ports connecting to the server into a List in this class. 
 * When we wand to send a message we send it to all the listening ports
 */

public class ServerThread extends Thread{
	private ServerSocket serverSocket;
	private Set<Socket> listeningSockets = new HashSet<Socket>();
	private ArrayList<Integer> socketList = new ArrayList<Integer>(); 
	private boolean timeToScan = false; 
	
	public ServerThread(String portNum) throws IOException {
		serverSocket = new ServerSocket(Integer.valueOf(portNum));
	}
	
	/**
	 * Starting the thread, we are waiting for clients wanting to talk to us, then save the socket in a list
	 */
	public void run() {
		try {
			while (true) {
				Socket sock = serverSocket.accept();
				System.out.println("[Server] Port " + sock.getPort() + " connected on port " + getPortNumber());
				if(true )
				{
					timeToScan = true; 
				}
				PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 
				String result = ""; 
				listeningSockets.add(sock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sending the message to the OutputStream for each socket that we saved
	 */
	// void sendMessage(String message) {
	// 	try {
	// 		for (Socket s : listeningSockets) {
	// 			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
	// 			out.println(message);
	// 	     }
	// 	} catch(Exception e) {
	// 		e.printStackTrace();
	// 	}
	// }

	public void sendMessage(String message) {
		try {
			if (message.equals("quit")) {
				message = "Server: Client disconnected.";
			}
	
			for (Socket socket : listeningSockets) {
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int getPortNumber()
	{
		return serverSocket.getLocalPort(); 
	}
	
	public boolean scanTime()
	{
		if(timeToScan)
		{
			timeToScan = false; 
			return true; 
		}
		else
			return false; 
	}

	public void restartServer(String portNum) {
        closeServerSocket();
        try {
            // Wait for a short duration before starting the server again
            Thread.sleep(1000);
            serverSocket = new ServerSocket(Integer.valueOf(portNum));
            start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

	private void closeServerSocket() {
        try {
            serverSocket.close(); // Close the server socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}