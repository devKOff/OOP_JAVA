import java.util.Set;
import java.util.TreeSet;

public class Treeset {
    public static void main(String[] args) {
        Set<String> inventory = new TreeSet<>();
        inventory.add("Sword");
        inventory.add("Potion");
        inventory.add("Shield");
        inventory.add("Potion"); // Duplicate, ignored

        System.out.println("TreeSet (sorted): " + inventory); // [Potion, Shield, Sword]
        System.out.println("First item: " + inventory.stream().findFirst().orElse("Empty")); // Potion
    }
}