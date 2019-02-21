import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            Path filePath = Paths.get("ex2numbers.txt");
            Scanner fileScanner = new Scanner(filePath);
            
            while (fileScanner.hasNext()) {
                if (fileScanner.hasNextInt()) {
                    printer.println(fileScanner.nextInt());
                    printer.flush();
                } else {
                    fileScanner.next();
                }
            }
            fileScanner.close();
            printer.println("end");
            printer.flush();
            String n = scanner.nextLine();
            while (! n.equals("end")) {
                System.out.println(n);
                n = scanner.nextLine();
            }
            socket.close();
        } 
    }
}