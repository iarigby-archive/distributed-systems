import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String [] args) throws Exception {
        int port = 12345;
        try (
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();

            Scanner scanner = new Scanner(s.getInputStream());
            PrintWriter printer = new PrintWriter(s.getOutputStream());
         ) {
            String text = scanner.nextLine();
            printer.println(text.length());
            printer.flush();
        } 
    }
}