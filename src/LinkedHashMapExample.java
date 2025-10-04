import java.util.*;

class LinkedHashMapExample {
    public static void main(String[] args) {
        // Create a LinkedHashMap
        Map<String, Double> teacherSalaries = new LinkedHashMap<>();

        // Adding key-value pairs (insertion order preserved)
        teacherSalaries.put("Amit", 55000.50);
        teacherSalaries.put("Priya", 45000.75);
        teacherSalaries.put("Vikas", 75000.00);
        teacherSalaries.put("Sneha", 60000.25);

        // Retrieving a value
        System.out.println("Sneha's salary: " + teacherSalaries.get("Sneha"));

        // Iterating over entries (in insertion order)
        System.out.println("\nAll Teachers and Salaries (insertion order):");
        for (Map.Entry<String, Double> entry : teacherSalaries.entrySet()) {
            System.out.println("Teacher: " + entry.getKey() + ", Salary: " + entry.getValue());
        }

        // Check size
        System.out.println("\nNumber of teachers: " + teacherSalaries.size());
    }
}