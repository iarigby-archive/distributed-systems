import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class Server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket ss = new ServerSocket(12345);
            while (true) {
                Socket socket = ss.accept(); 
                try {
                    Object lock = new Object();
                    System.out.println("connection started: ");
                    Connection sender = new Connection(new PrintWriter(socket.getOutputStream()), lock);
                    Connection receiver = new Connection(new Scanner(socket.getInputStream()), lock);
                    receiver.run();
                    sender.run();
                } catch (Exception e) {
                    System.out.println("connection closed");
                } 
            }
        } catch (Exception e) {
            System.out.println(e);
        }      
    }
}