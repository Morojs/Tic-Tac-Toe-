package ma.classes;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Serveur {

	private int port;
	private ServerSocket _serverSocket;
	private Socket _socket;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	private InputStream flux;
	private char[][] matrice;

	public Serveur(int port) throws IOException, ClassNotFoundException {
		super();
		this.port = port;
		this._serverSocket = new ServerSocket(this.port);

	}

	public void read() throws IOException, ClassNotFoundException {
		System.out.println("ServerSocket awaiting connections...");
		while (true) {
			this._socket = _serverSocket.accept();
			// create a DataInputStream so we can read data from it.
			this.flux = _socket.getInputStream();
			objectInputStream = new ObjectInputStream(this.flux);
			matrice = (char[][]) objectInputStream.readObject();

			for (int l = 0; l < matrice.length; l++) {
				for (int c = 0; c < matrice.length; c++)
					System.out.println(matrice[l][c]);
			}
			
			System.out.println("data reçu sur le serveur ");
			
			objectOutputStream=new ObjectOutputStream(this._socket.getOutputStream());
			objectOutputStream.writeObject(this.matrice);
	        this.objectOutputStream.flush();
		}
		 //System.out.println("Closing sockets.");
		 //this._serverSocket.close();
	}
}
