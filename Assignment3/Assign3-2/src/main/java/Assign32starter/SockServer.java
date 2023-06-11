 package Assign32starter;
 import java.net.*;
 import java.util.Base64;
 import java.util.Set;
 import java.util.Stack;
 import java.util.*;
 
 import javax.imageio.ImageIO;
 import javax.swing.ImageIcon;
 
 import java.awt.image.BufferedImage;
 import java.io.*;
 import org.json.*;


// public class SockServer {
// 	static Stack<String> imageSource = new Stack<String>();

// 	public static void main (String args[]) {
// 		Socket sock;
// 		try {
// 			ServerSocket serv = new ServerSocket(8888);
// 			System.out.println("Server ready for connetion");

// 			String name = "";
// 			int points = 0;

// 			while(true) {
// 				sock = serv.accept();

// 				ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
// 				OutputStream out = sock.getOutputStream();

// 				String s = (String) in.readObject();
// 				JSONObject json = new JSONObject(s); 

// 				JSONObject response = new JSONObject();

// 				if (json.getString("type").equals("start")){
					
// 					System.out.println("- Got a start");
				
// 					response.put("type","hello" );
// 					response.put("value","Hello, please tell me your name." );
// 					sendImg("img/hi.png", response); 
					
// 				}
// 				else {
// 					System.out.println("not sure what you meant");
// 					response.put("type","error" );
// 					response.put("message","unknown response" );
// 				}
// 				PrintWriter outWrite = new PrintWriter(sock.getOutputStream(), true); 
// 			}
			
// 		} catch(Exception e) {e.printStackTrace();}
// 	}

// 	public static JSONObject sendImg(String filename, JSONObject obj) throws Exception {
// 		File file = new File(filename);

// 		if (file.exists()) {
// 			obj.put("image", "Pretend I am this image: " + filename);
// 		} 
// 		return obj;
// 	}
// }


public class SockServer {
    static Stack<String> imageSource = new Stack<String>();

    public static void main(String args[]) {
        Socket sock;
        try {
            ServerSocket serv = new ServerSocket(8888);
            System.out.println("Server ready for connection");

            String name = "";
            int points = 0;

            while (true) {
                sock = serv.accept();

                ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
                OutputStream out = sock.getOutputStream();

                String s = (String) in.readObject();
                JSONObject json = new JSONObject(s);

                JSONObject response = new JSONObject();

                if (json.getString("type").equals("start")) {
                    System.out.println("- Got a start");

                    response.put("type", "hello");
                    response.put("value", "Hello, please tell me your name.");
                    sendImg("img/hi.png", response);

                } else {
                    System.out.println("not sure what you meant");
                    response.put("type", "error");
                    response.put("message", "unknown response");
                }
                PrintWriter outWrite = new PrintWriter(sock.getOutputStream(), true);
                outWrite.println(response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject sendImg(String filename, JSONObject obj) throws Exception {
        File file = new File(filename);

        if (file.exists()) {
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            obj.put("image", base64Image);
        }
        return obj;
    }
}
