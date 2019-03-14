import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    public String family_name;
    public String message;

    public Person(String n, String f) {
        name = n;
        family_name = f;
    }

    @Override
    public String toString() {
        return name + " " + family_name + " - " + message;
    }
}