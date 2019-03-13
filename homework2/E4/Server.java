import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    public static void main(String[] args) {
        try {
            System.out.println("s here");
            ServerSocket ss = new ServerSocket(12345);
            Socket s = ss.accept();
            ObjectInputStream input = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
            System.out.println("s here");
            Person p1 = (Person) input.readObject();
            // Person p2 = (Person) input.readObject();
             
            // p2.family_name = p1.family_name;
            String message = "happy wedding";
            p1.message = message;
            // p2.message = message;

            outputStream.writeObject(p1);
            // outputStream.writeObject(p2);
            outputStream.flush();
            ss.close();
        } catch (Exception e) {}
    }
}