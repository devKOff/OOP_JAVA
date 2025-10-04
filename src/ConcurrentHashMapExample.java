import java.util.*;
import java.util.concurrent.*;

class ConcurrentHashMapExample {
    public static void main(String[] args) {
        // Create a ConcurrentHashMap
        Map<String, Double> teacherSalaries = new ConcurrentHashMap<>();

        // Adding key-value pairs
        teacherSalaries.put("Amit", 55000.50);
        teacherSalaries.put("Priya", 45000.75);
        teacherSalaries.put("Vikas", 75000.00);
        teacherSalaries.put("Sneha", 60000.25);

        // Retrieving a value
        System.out.println("Priya's salary: " + teacherSalaries.get("Priya"));

        // Iterating over entries (order not guaranteed)
        System.out.println("\nAll Teachers and Salaries:");
        for (Map.Entry<String, Double> entry : teacherSalaries.entrySet()) {
            System.out.println("Teacher: " + entry.getKey() + ", Salary: " + entry.getValue());
        }

        // Check size
        System.out.println("\nNumber of teachers: " + teacherSalaries.size());

        // Adding null key
        teacherSalaries.put(null, 50000.00); // Allowed in ConcurrentHashMap
        System.out.println("\nAfter adding null key: " + teacherSalaries);
    }
}