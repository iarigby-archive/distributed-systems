import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static String text = "sometext ";
    public static void main(String [] args) throws Exception {
        int port = 12345;
        try (
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();

            Scanner scanner = new Scanner(s.getInputStream());
            PrintWriter printer = new PrintWriter(s.getOutputStream());
         ) {
            String n = scanner.nextLine();
            try {
                for (int i = 0; i < Integer.parseInt(n); i++) {
                    printer.print(text);
                }
                printer.println();
            } catch (NumberFormatException e) {
                printer.println("you should send a number");
            }
            
            printer.flush();
            s.close();
        } 
    }
}