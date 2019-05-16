import java.util.*;
import java.io.*;
import java.net.*;

public class Client{
	
	public static void main(String [] args){
		int port=12345;
		String computer = "localhost";
		
		try{
			Socket socket = new Socket(computer, port);
			
			ObjectOutputStream outputStream = 
				new ObjectOutputStream(socket.getOutputStream());
				
			ObjectInputStream input = 
				new ObjectInputStream(socket.getInputStream());
		       
			String msg = (String)input.readObject();
			System.out.println("server is " + msg);
			ConnectionToRMI connectionToRMI1 = (ConnectionToRMI)input.readObject();
			ConnectionToRMI connectionToRMI2 = (ConnectionToRMI)input.readObject();
			System.out.println(connectionToRMI1);
			System.out.println(connectionToRMI2);
			
			outputStream.close();
			
			input.readObject();
			
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}
	}
	
	
	
}
