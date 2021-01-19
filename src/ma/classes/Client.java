package ma.classes;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	private int port;
	private InetAddress hote;
	private Socket _socket;
	private OutputStream flux;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream entree;
	public static char[][] matrice;
	
	public Client(InetAddress hote,int port) throws UnknownHostException, IOException {
		super();
		this.port=port;
		this.hote = hote;
       /* // make a bunch of messages to send.
        List<Integer> messages = new ArrayList<Integer>();
        messages.add(1);
        messages.add(2);
        messages.add(3);
        messages.add(4);

        System.out.println("Sending messages to the ServerSocket");
        objectOutputStream.writeObject(messages);

        System.out.println("Closing socket and terminating program.");
        socket.close();*/
		
	}
	public void read() throws IOException, ClassNotFoundException {
		// Réception du Nouvelle matrice
		
		entree = new ObjectInputStream (this._socket.getInputStream());
		matrice = (char[][]) entree.readObject();
		for (int l = 0; l < matrice.length; l++) {
			for (int c = 0; c < matrice.length; c++)
				System.out.println(matrice[l][c]);
		}
	}
	public void play() throws IOException {
		System.out.println("Sending data to the ServerSocket");
		this._socket=new Socket(this.hote,this.port);
		this.flux=this._socket.getOutputStream();
		this.objectOutputStream = new ObjectOutputStream(this.flux);
        objectOutputStream.writeObject(this.matrice);
        this.objectOutputStream.flush();
       // System.out.println("Closing socket and terminating program.");
       // this._socket.close();
	}
	
	public Socket getClientSocket() { return this._socket; }
	
}
