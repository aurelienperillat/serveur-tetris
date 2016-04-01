import java.net.Socket;

public class Client {
	private String pseudo;
	private Socket socket;
	
	public Client(String pseudo, Socket socket){
		this.pseudo = pseudo;
		this.socket = socket;
	}
	
	public String getPseudo() { return pseudo; }
	public Socket getSocket() { return socket; }
}