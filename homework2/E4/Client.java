import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class Client {
    public static void main(String[] args) {
        Person p1 = new Person("Ann", "Smith");
        Person p2 = new Person("Tom", "Parker");
        
        try {
            Socket s = new Socket("localhost", 12345);
            ObjectInputStream input = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
            
            System.out.println("c here");
            outputStream.writeObject(p1);
            // outputStream.flush();
            // outputStream.writeObject(p2);
            // outputStream.flush();
            p1 = (Person) input.readObject();
            // p2 = (Person) input.readObject();
            System.out.println(p1);
            System.out.println(p2);
        } catch (Exception e) {}
    }
}