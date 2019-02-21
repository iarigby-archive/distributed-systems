import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String [] args) throws Exception {
        int port = 12345;
        String computer = "localhost";
        try (
            Socket socket = new Socket(computer, port);
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printer = new PrintWriter(socket.getOutputStream());
         ) {
            printer.println(args[0]);
            printer.flush();
            String text = scanner.nextLine();
            System.out.println(text);
            socket.close();
        } 
    }
}