import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class Server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket ss = new ServerSocket(12345);
            Socket s1 = ss.accept(); 
            System.out.println("waiting for second connection...");
            Socket s2 = ss.accept();
            System.out.println("connected");
            Object lock = new Object();
            Member c1 = new Member("u1", s1, s2, lock);
            Member c2 = new Member("u2", s2, s1, lock);
            c1.run();
            c2.run();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }      
    }
}

class Member extends Thread {
    String name;
    PrintWriter friend;
    Scanner sc;
    Object lock;

    public Member(String name, Socket me, Socket s, Object o) throws Exception {
        this.name = name;
        sc = new Scanner(me.getInputStream());
        friend = new PrintWriter(s.getOutputStream());
        lock = o;
        System.out.println(name + " added");
    }

    @Override
    public void run() {
        while (true) {
            String msg = sc.nextLine();
            // synchronized (lock) {
                System.out.println(name + ": " + msg);
                friend.println(msg);
                friend.flush();
            // }
        }
    }
}