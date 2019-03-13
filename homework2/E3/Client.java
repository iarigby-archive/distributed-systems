import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 12345);) {
            Object lock = new Object();
            Sender s = new Sender(socket, lock);
            Receiver r = new Receiver(socket, lock);
            s.run();
            r.run();
        }
    }
}

class Sender extends Thread {
    Object lock;
    Scanner userInput;
    PrintWriter output;
    public Sender(Socket s, Object o) throws Exception {
        lock = o;
        userInput = new Scanner(System.in);
        output = new PrintWriter(s.getOutputStream());
    }

    @Override
    public void run() {
        while (userInput.hasNext()) {
            String message = userInput.nextLine();
            // synchronized(lock) {
                output.println(message);
                output.flush();
            // }
        }
    }
}

class Receiver extends Thread {
    Object lock;
    Scanner sc;

    public Receiver(Socket s, Object o) throws Exception {
        lock = o;
        sc = new Scanner(s.getInputStream());
    }

    @Override
    public void run() {
        while(true) {
            String msg = sc.nextLine();
            // synchronized(lock) {
                System.out.println("them: " + msg);
            // }
        }
    }
}