package ma.test;


import java.io.IOException;
import ma.classes.Serveur;

public class TestServer {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		 // don't need to specify a hostname, it will be the current machine
		Serveur _server=new Serveur(1000);
		_server.read();
      

	}
}

