import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: Node
 * Description: Node tasks.
 */
class Node {
    public static void main(String[] args) throws Exception {
        int port;
        List<String> bookList = getBookList();

        if (args.length != 2) {
            // gradle runNode -Pport=9099 -PserverPort=9999 -q --console=plain
            System.out.println("Usage: gradle runNode -Pport=9099 -PserverPort=9999 -q --console=plain");
            System.exit(1);
        }
        port = -1;
        int serverPort = -1;
    
        try {
            port = Integer.parseInt(args[0]);
            serverPort = Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("[Port] and [ServerPort] must be integers");
            System.exit(2);
        }
    
        Socket socket = new Socket("localhost", serverPort);
        System.out.println("Connected to the server...");
    
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
    
        JSONObject message = new JSONObject();
        message.put("option", "node");
        message.put("port", port);
    
        NetworkUtils.send(out, JsonUtils.toByteArray(message));
    
        byte[] responseBytes = NetworkUtils.receive(in);
        JSONObject response = JsonUtils.fromByteArray(responseBytes);
    
        System.out.println(response.get("greeting"));
    
        if (response.has("bookList")) {
            List<String> serverBookList = (List<String>) response.get("bookList");
            System.out.println("Received book list from the server:");
            for (String book : serverBookList) {
                System.out.println(book);
            }
        }
    
        socket.close();
    }
    
    private static List<String> getBookList() {
        List<String> bookList = new ArrayList<>();
        // Read the book list from a file or any other source
        // Example:
        bookList.add("Book A");
        bookList.add("Book B");
        bookList.add("Book C");
        // ...
    
        return bookList;
    }
}    






