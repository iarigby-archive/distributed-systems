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
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
                printer.println(args[i]);
                printer.flush();
                String n = scanner.nextLine();
                System.out.println(n);
            }
            printer.println("exit");
            printer.flush();
            socket.close();
        } 
    }
}