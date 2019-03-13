public class Person {
    String name;
    String family_name;
    String message;

    public Person(String n, String f) {
        name = n;
        family_name = f;
    }

    @Override public String toString() {
        return name + " " + family_name + " - " + message;
    }
}