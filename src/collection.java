import java.util.*;

public class collection {
    public static void main(String[] args) {
        // List: Ordered, duplicates allowed
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple");  // Duplicate OK
        System.out.println(fruits);  // [Apple, Banana, Apple]

        // Sort using algorithm
        Collections.sort(fruits);
        System.out.println(fruits);  // [Apple, Apple, Banana]

        // Map: Key-value
        Map<String, Integer> stock = new HashMap<>();
        stock.put("Apple", 10);
        stock.put("Banana", 5);
        System.out.println(stock.get("Apple"));  // 10

        // Iterate over Map
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}