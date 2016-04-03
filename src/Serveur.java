import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Serveur {
	public static ServerSocket socketserver  ;
	public static Socket socket ;
	public static BufferedReader in;
	public static Thread t;
	private static ArrayList<Client> listClient = new ArrayList<Client>();

	public static void main(String[] zero) {
		
		try {
			socketserver = new ServerSocket(2009);
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
			
			while(true){
				socket = socketserver.accept();
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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