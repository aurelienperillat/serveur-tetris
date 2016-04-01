import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Transmission implements Runnable{
	private BufferedReader in;
	private PrintWriter out;
	private String message = null;
	private Client myClient;
	private ArrayList<Client> listClient;
	
	public Transmission(ArrayList<Client> list, Client client){ 
		this.listClient = list; 
		this.myClient = client;
	}
	
	public void run() {
		
		while(true){
	        try {
	        	in = new BufferedReader(new InputStreamReader(myClient.getSocket().getInputStream()));
	        	message = in.readLine();
	        	
			for(Client client : listClient){
				if(client != myClient){
					out = new PrintWriter(client.getSocket().getOutputStream());
					out.println(message);
					out.flush();
				}
			}
			
			System.out.println(message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
