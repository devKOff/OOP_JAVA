import java.util.*;

class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap
        Map<String, Double> teacherSalaries = new HashMap<>();

        // Adding key-value pairs
        teacherSalaries.put("Amit", 55000.50);
        teacherSalaries.put("Priya", 45000.75);
        teacherSalaries.put("Vikas", 75000.00);
        teacherSalaries.put(null, 50000.00); // HashMap allows null key

        // Retrieving a value
        System.out.println("Priya's salary: " + teacherSalaries.get("Priya"));

        // Iterating over entries (order not guaranteed)
        System.out.println("\nAll Teachers and Salaries:");
        for (Map.Entry<String, Double> entry : teacherSalaries.entrySet()) {
            System.out.println("Teacher: " + entry.getKey() + ", Salary: " + entry.getValue());
        }

        // Check size
        System.out.println("\nNumber of teachers: " + teacherSalaries.size());
    }
}