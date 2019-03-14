import java.io.*;
import java.util.*;
import java.net.*;

class Client {
    public static void main(String[] args) {
        Person p1 = new Person("Ann", "Smith");
        Person p2 = new Person("Tom", "Parker");
        
        try {
            Socket s = new Socket("localhost", 12345);
            ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(s.getInputStream());
            
            outputStream.writeObject(p1);
            outputStream.writeObject(p2);
            p1 = (Person) input.readObject();
            p2 = (Person) input.readObject();
            outputStream.close();
            System.out.println(p1);
            System.out.println(p2);
        } catch (Exception e) {
            System.out.println(e);}
    }
}