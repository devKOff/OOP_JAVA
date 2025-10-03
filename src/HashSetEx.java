import java.util.Set;
import java.util.HashSet;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> characters = new HashSet<>();
        characters.add("Boy");
        characters.add("club");
        characters.add("Boy");
        characters.add("Dev");
        characters.add("Haley");
        System.out.println(characters);
        System.out.println("HashSet: " + characters);
        System.out.println(characters.contains("Dev"));
        characters.remove("Boy");
        System.out.println(characters);
    }
}