import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private static String text = "sometext ";
    public static void main(String [] args) throws Exception {
        int port = 12345;
        try (
            ServerSocket ss = new ServerSocket(port);
         ) {
             int n = 0;
            while (true) {
                try (
                    Socket s = ss.accept();
                    Scanner scanner = new Scanner(s.getInputStream());
                    PrintWriter printer = new PrintWriter(s.getOutputStream());
                ) {
                    n++;
                    printer.println(n);
                    printer.flush();
                    s.close();
                }
            }  
        } 
    }
}