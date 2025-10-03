import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class hastag {
    public static void main(String[] args) {
        Set<String> hS = new HashSet<>();
        hS.add("D");
        hS.add("C");
        hS.add("B");
        hS.add("A");
        hS.add("l");
        hS.add("r");

        System.out.println("HashSet: " + hS);

        Set<String> linkedHashSet = new LinkedHashSet<>(hS);
        System.out.println("LinkedHashSet: " + linkedHashSet);
    }
}
