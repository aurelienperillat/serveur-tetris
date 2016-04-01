import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Serveur {
	public static ServerSocket socketserver  ;
	public static Socket socket ;
	public static BufferedReader in;
	public static PrintWriter out;
	public static Thread t;
	private static ArrayList<Client> listClient = new ArrayList<Client>();

	public static void main(String[] zero) {
		
		try {
			socketserver = new ServerSocket(2009,2);
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
			
			while(true){
				socket = socketserver.accept();
				String message = in.readLine();
				System.out.println(message+" connected");
				
				Client client = new Client(message,socket);
				listClient.add(client);
				
				t = new Thread(new Transmission(listClient, client));
				t.start();
		
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}