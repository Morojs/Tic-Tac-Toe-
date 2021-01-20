package ma.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Client {

	private int port;
	private InetAddress hote;
	private Socket _socket;
	private OutputStream flux;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream entree;
	private char[] tabGame;
	public static char[][] matrice;

	public Client(InetAddress hote, int port) throws UnknownHostException, IOException {
		super();
		this.port = port;
		this.hote = hote;
		/*
		 * // make a bunch of messages to send. List<Integer> messages = new
		 * ArrayList<Integer>(); messages.add(1); messages.add(2); messages.add(3);
		 * messages.add(4);
		 * 
		 * System.out.println("Sending messages to the ServerSocket");
		 * objectOutputStream.writeObject(messages);
		 * 
		 * System.out.println("Closing socket and terminating program.");
		 * socket.close();
		 */

	}

	public void read() throws IOException, ClassNotFoundException {
		// Réception du Nouvelle matrice
		
		List<Object> obj=new ArrayList<Object>();
		entree = new ObjectInputStream(this._socket.getInputStream());
		obj.add(0,entree.readObject());
		
		if (!obj.get(0).getClass().getTypeName().equals("char[]")){
			matrice = (char[][]) obj.get(0);
			for (int l = 0; l < matrice.length; l++) {
				for (int c = 0; c < matrice.length; c++)
					System.out.println(matrice[l][c]);
			}	
		}
		else {
			tabGame = (char[]) obj.get(0);
		}
	}

	public char[] getTabGame() {
		return tabGame;
	}
	public void setTabGame(char[] tabGame) {
		this.tabGame = tabGame;
	}

	public void play() throws IOException {
		System.out.println("Sending data to the ServerSocket");
		this._socket = new Socket(this.hote, this.port);
		this.flux = this._socket.getOutputStream();
		this.objectOutputStream = new ObjectOutputStream(this.flux);
		objectOutputStream.writeObject(this.matrice);
		this.objectOutputStream.flush();
		// System.out.println("Closing socket and terminating program.");
		// this._socket.close();
	}

	public Socket getClientSocket() {
		return this._socket;
	}

}
