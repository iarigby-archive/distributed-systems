
import java.util.*;
import java.io.*;
import java.net.*;

class Server {
    public static void main(String[] args) throws Exception {
        int port = 12345;

        try (ServerSocket ss = new ServerSocket(port);) {
            try {
                Socket player1 = ss.accept();
                // TODO: try to pass these
                Scanner sc1 = new Scanner(player1.getInputStream());
                PrintWriter pw1 = new PrintWriter(player1.getOutputStream());
                Socket player2 = ss.accept();
                // TODO: try to pass these
                Scanner sc2 = new Scanner(player2.getInputStream());
                PrintWriter pw2 = new PrintWriter(player2.getOutputStream());
                Game game = new Game();
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
}
