import java.util.*;

class TreeMapExample {
    public static void main(String[] args) {
        // Create a TreeMap
        Map<String, Double> teacherSalaries = new TreeMap<>();

        // Adding key-value pairs
        teacherSalaries.put("Amit", 55000.50);
        teacherSalaries.put("Priya", 45000.75);
        teacherSalaries.put("Vikas", 75000.00);
        teacherSalaries.put("Sneha", 60000.25);

        // Retrieving a value
        System.out.println("Vikas's salary: " + teacherSalaries.get("Vikas"));

        // Iterating over entries (sorted by key)
        System.out.println("\nAll Teachers and Salaries (sorted by name):");
        for (Map.Entry<String, Double> entry : teacherSalaries.entrySet()) {
            System.out.println("Teacher: " + entry.getKey() + ", Salary: " + entry.getValue());
        }

        // Check size
        System.out.println("\nNumber of teachers: " + teacherSalaries.size());
    }
}