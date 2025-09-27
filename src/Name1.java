
class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName1, String lastName2) {
        this.firstName = firstName1;
        this.lastName = lastName2;
    }
    public String toString() {
        return this.firstName.concat(" ").concat(this.lastName);
    }
}

public class Name1 {

    public static void main(String[] args) {
        Name myName = new Name("Devendra", "Kashyap");

        System.out.println(myName);
    }
}
