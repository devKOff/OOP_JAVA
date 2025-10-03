import java.util.HashSet;
import java.util.Set;

public class SetOperation {
    public static void main(String[] args) {
        Set<String> party1 = new HashSet<>();
        party1.add("Roy");
        party1.add("Elan");
        party1.add("Haley");

        Set<String> party2 = new HashSet<>();
        party2.add("Haley");
        party2.add("Vaarsuvius");
        party2.add("Belkar");

        // Union
        Set<String> union = new HashSet<>(party1);
        union.addAll(party2);
        System.out.println("Union: " + union); // e.g., [Haley, Roy, Elan, Vaarsuvius, Belkar]

        // Intersection
        Set<String> intersection = new HashSet<>(party1);
        intersection.retainAll(party2);
        System.out.println("Intersection: " + intersection); // [Haley]
    }
}