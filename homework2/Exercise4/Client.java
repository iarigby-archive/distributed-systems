import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name of the host: ");
            String computer = sc.nextLine();
            System.out.println("Enter port number");
            int port = sc.nextInt();
            Socket socket = new Socket(computer, port);
            Object lock = new Object();
            System.out.println("can send messages to server that it receives, but other directino not working");
            // whichever side starts running the sender first works, dunno
            Connection sender = new Connection(new PrintWriter(socket.getOutputStream()), lock);
            Connection receiver = new Connection(new Scanner(socket.getInputStream()), lock);
            sender.run();
            receiver.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
