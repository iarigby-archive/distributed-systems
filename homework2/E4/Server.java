import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(12345);
            Socket s = ss.accept();
            ObjectInputStream input = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
            
            Person p1 = (Person)input.readObject();
            Person p2 = (Person) input.readObject();
            
            p2.family_name = p1.family_name;
            String message = "happy wedding";
            p1.message = message;
            p2.message = message;
            
            outputStream.writeObject(p1);
            outputStream.writeObject(p2);
            outputStream.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}