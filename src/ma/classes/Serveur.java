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
	private TicTac _ticTac;
	public Serveur(int port) throws IOException, ClassNotFoundException {
		super();
		this.port = port;
		this._serverSocket = new ServerSocket(this.port);
		this._ticTac=new TicTac('X');
	}

	public void read() throws IOException, ClassNotFoundException {
		System.out.println("ServerSocket awaiting connections...");
		while (true) {
			this._socket = _serverSocket.accept();
			// create a DataInputStream so we can read data from it.
			this.flux = _socket.getInputStream();
			objectInputStream = new ObjectInputStream(this.flux);
			_ticTac.matrice = (char[][]) objectInputStream.readObject();
			_ticTac.playState();
			System.out.println("play state done ! sur le serveur ");
		
			objectOutputStream=new ObjectOutputStream(this._socket.getOutputStream());
			objectOutputStream.writeObject(_ticTac.matrice);
	        this.objectOutputStream.flush();
		}
		 //System.out.println("Closing sockets.");
		 //this._serverSocket.close();
	}
}
