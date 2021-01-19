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
       /* ServerSocket ss = new ServerSocket(1000);
        System.out.println("ServerSocket awaiting connections...");
        Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Connection from " + socket + "!");

        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        // read the list of messages from the socket
        List<Integer> listOfMessages = (List<Integer>) objectInputStream.readObject();
        System.out.println("Received [" + listOfMessages.size() + "] messages from: " + socket);
        // print out the text of every message
        System.out.println("All messages:");
        listOfMessages.forEach((msg)-> System.out.println(msg));

        System.out.println("Closing sockets.");
        ss.close();
        socket.close();*/

	}
}

