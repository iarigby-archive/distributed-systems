import java.util.*;
import java.io.*;
import java.net.*;

public class Server{
	public static void main (String [] args){
		
		int port = 12345;
						ConnectionToRMI connectionToRMI1 = new ConnectionToRMI("localhost", 12345, "service1");
		ConnectionToRMI connectionToRMI2 = new ConnectionToRMI("localhost", 54321, "service2");	

		try{
			ServerSocket ss = new ServerSocket(port);
			Socket socket = ss.accept();				
			
			ObjectInputStream input = 
				new ObjectInputStream(socket.getInputStream());
			
			ObjectOutputStream outputStream = 
				new ObjectOutputStream(socket.getOutputStream());

			outputStream.writeObject("ready");
			outputStream.writeObject(connectionToRMI1);
			outputStream.writeObject(connectionToRMI2);
			
			socket.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
}
