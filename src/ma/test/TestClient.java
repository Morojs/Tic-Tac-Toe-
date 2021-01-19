package ma.test;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


import ma.classes.Client;


public class TestClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		 Client _client=new Client(InetAddress.getLocalHost(),4040);
		_client.play();
	
	}
}