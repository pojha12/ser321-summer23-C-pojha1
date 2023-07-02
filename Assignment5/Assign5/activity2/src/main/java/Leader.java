import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Class: Server
 * Description: Server tasks.
 */
class Leader {
    public static List<Integer> nodes = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception {
        int port;

        if (args.length != 1) {
            // gradle runServer -Pport=9099 -q --console=plain
            System.out.println("Usage: gradle runServer -Pport=9099 -q --console=plain");
            System.exit(1);
        }
        port = -1;
        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException nfe) {
            System.out.println("[Port] must be an integer");
            System.exit(2);
        }
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server Started...");

        boolean quit = false;
        OutputStream out = null;
        InputStream in = null;
        int amount = 0;

        while (!quit) {
            System.out.println("Accepting a Request...");
            Socket clientSock = server.accept();

            out = clientSock.getOutputStream();
            in = clientSock.getInputStream();
            System.out.println("Server connected to client:");

            byte[] messageBytes = NetworkUtils.receive(in);
            JSONObject message = JsonUtils.fromByteArray(messageBytes);
            JSONObject returnMessage = new JSONObject();

            if (message.get("option").equals("node")) {
                System.out.println("Library#" + message.get("port") + " has been added to the network.");
                nodes.add(message.getInt("port"));
                returnMessage.put("greeting", "You have been added to the library");
                returnMessage.put("bookList", getBookList());
            } else {
                // Handle other message options...
            }

            if (returnMessage == null) {
                returnMessage.put("greeting", "I haven't set up a response message yet");
            }

            byte[] output = JsonUtils.toByteArray(returnMessage);
            NetworkUtils.send(out, output);

            try {
                System.out.println("Close socket of client");
                clientSock.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> getBookList() {
        List<String> bookList = new ArrayList<>();
        // Read the book list from a file or any other source
        // Example:
        bookList.add("Book 1");
        bookList.add("Book 2");
        bookList.add("Book 3");
        // ...

        return bookList;
    }
}




