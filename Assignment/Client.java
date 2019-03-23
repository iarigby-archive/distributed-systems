import java.util.*;
import java.io.*;
import java.net.*;

class Client {
    public static void main(String[] args) throws Exception {
        int port = 12345;
        String computer = "localhost";

        try {
            Socket s = new Socket(computer, port);
            Scanner sc = new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            Scanner input = new Scanner(System.in);
            while (sc.hasNext()) {
                System.out.println(sc.next());
                pw.println(input.nextLine());
                pw.flush();
            }
            input.close();
            sc.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
