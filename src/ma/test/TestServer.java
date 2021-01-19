package ma.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import ma.classes.Serveur;

public class TestServer {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		 // don't need to specify a hostname, it will be the current machine
		Serveur _server=new Serveur(4040);
		_server.read();
      

	}
}

