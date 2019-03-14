import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Connection extends Thread {
    Object lock;
    Scanner sc;
    PrintWriter pw;

    public Connection(Scanner s, Object o) throws Exception {
        this(s, new PrintWriter(System.out), o);
    }

    public Connection(Scanner s, PrintWriter p, Object o) throws Exception {
        lock = o;
        sc = s;
        pw = p;
    }

    public Connection(PrintWriter p, Object o) throws Exception {
        this(new Scanner(System.in), p, o);
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(10);
            } catch (Exception e) {}
            String msg = sc.nextLine();
            synchronized(lock) {
                pw.println(msg);
                pw.flush();
            }
        }
    }
}