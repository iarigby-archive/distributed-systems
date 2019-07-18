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
            while (true) {

                String msg = sc.nextLine();
                System.out.println(msg);
                if (msg.contains("enter")) {
                    pw.println(input.nextLine());
                    pw.flush();
                }
                if (msg.contains("won"))
                    break;
            }
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
