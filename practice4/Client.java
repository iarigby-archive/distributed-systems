import java.io.*;
import java.util.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        int port = 12345;
        String computer =  "localhost";

        Animal animal = new Animal("Cat Joe");
        try  {
            Socket socket = new Socket(computer, port);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            
            outputStream.writeObject(animal);

            socket.close();
        } catch (Exception e) {}
    }

}