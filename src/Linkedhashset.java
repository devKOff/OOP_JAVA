import java.util.LinkedHashSet;
import java.util.Set;

public class Linkedhashset {
    public static void main(String[] args) {
        Set<String> spellBook = new LinkedHashSet<>();
        spellBook.add("Fireball");
        spellBook.add("Heal");
        spellBook.add("Fireball"); // Duplicate, ignored
        spellBook.add("Teleport");

        System.out.println("LinkedHashSet (insertion order): " + spellBook); // [Fireball, Heal, Teleport]
        spellBook.clear();
        System.out.println("Is spellBook empty? " + spellBook.isEmpty()); // true
    }
}