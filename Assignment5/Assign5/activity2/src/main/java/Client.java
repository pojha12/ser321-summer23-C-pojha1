import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.JSONObject;
import java.util.InputMismatchException;
import java.util.Random;

/**
 * Class: Client
 * Description: Client tasks.
 */
public class Client {
    private static BufferedReader stdin;
    public static int clientID; 
    /**
     * Function main().
     */
    public static void main(String[] args) throws IOException {
        String host;
        int port;
        Socket sock;
        stdin = new BufferedReader(new InputStreamReader(System.in));
        boolean quit = false; 
        try {
            if (args.length != 2) {
                // gradle runClient -Phost=localhost -Pport=9099 -q --console=plain
                System.out.println("Usage: gradle runClient -Phost=localhost -Pport=9099");
                System.exit(0);
            }

            host = args[0];
            port = -1;
            try {
                port = Integer.parseInt(args[1]);
            } catch (NumberFormatException nfe) {
                System.out.println("[Port] must be an integer");
                System.exit(2);
            }
            
            //0.002% chance of same ID
            Random rand = new Random(); 
            clientID = rand.nextInt(50000); 
            
            
            Scanner input = new Scanner(System.in);
            do {
                String strToSend = null;
                int choice = -1;
                JSONObject request = new JSONObject();
                System.out.println();
                // TODO: you will need to change the menu based on the tasks for this assignment, see Readme!
                System.out.println("Client Menu");
                System.out.println("Select [borrow] or [return]");
                System.out.println("[borrow] - request a book from the library");
                System.out.println("[return] - return a book to the library");
                System.out.println();
               
                try {
                    strToSend = stdin.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                if(strToSend.equals("borrow"))
                {
                	System.out.println("What book do you want to borrow?"); 
                	choice = input.nextInt(); 
                }
                else if(strToSend.equals("return"))
                {
                	System.out.println("What book do you want to return?"); 
                	choice = input.nextInt(); 
                }
                else if(strToSend.equals("quit"))
                {
                	quit = true; 
                }

                sock = new Socket(host, port);
                OutputStream out = sock.getOutputStream();
                InputStream in = sock.getInputStream();
                
                request.put("option", strToSend);
                request.put("book", choice); 
                request.put("id", clientID); 
                
                if (request != null) {
                    NetworkUtils.send(out, JsonUtils.toByteArray(request));
                    byte[] responseBytes = NetworkUtils.receive(in);
                    JSONObject response = JsonUtils.fromByteArray(responseBytes);
                    
                    System.out.println(response.getString("greeting")); 
                }
                
            } while (!quit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
