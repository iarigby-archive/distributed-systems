import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private static String text = "sometext ";
    public static void main(String [] args) throws Exception {
        int port = 12345;
        try (
            ServerSocket ss = new ServerSocket(port);
         ) {
             while(true) {
                 try (
                    Socket s = ss.accept();
                    Scanner scanner = new Scanner(s.getInputStream());
                    PrintWriter printer = new PrintWriter(s.getOutputStream());
                 ) {
                    List<Integer> integers = new ArrayList<>();
                    String number = scanner.nextLine();
                    while (! number.equals("end")) {
                        try {
                            integers.add(Integer.parseInt(number));
                            number = scanner.nextLine();
                        } catch (NumberFormatException e) {
                            printer.println("skipped non number");
                        }
                    }
                    integers.forEach((n) -> {
                        printer.println(2*n+1);
                        printer.flush();
                    });
                    printer.println("end");
                    printer.flush();
                    s.close();
                 }
             }
        } 
    }
}