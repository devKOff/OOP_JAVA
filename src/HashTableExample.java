import java.util.*;

class HashtableExample {
    public static void main(String[] args) {
        // Create a Hashtable
        Map<String, Double> teacherSalaries = new Hashtable<>();

        // Adding key-value pairs
        teacherSalaries.put("Amit", 55000.50);
        teacherSalaries.put("Priya", 45000.75);
        teacherSalaries.put("Vikas", 75000.00);
        teacherSalaries.put("Sneha", 60000.25);

        // Retrieving a value
        System.out.println("Amit's salary: " + teacherSalaries.get("Amit"));

        // Iterating over entries (order not guaranteed)
        System.out.println("\nAll Teachers and Salaries:");
        for (Map.Entry<String, Double> entry : teacherSalaries.entrySet()) {
            System.out.println("Teacher: " + entry.getKey() + ", Salary: " + entry.getValue());
        }

        // Check size
        System.out.println("\nNumber of teachers: " + teacherSalaries.size());

        // Trying to add null key (will throw NullPointerException)
        try {
            teacherSalaries.put(null, 50000.00);
        } catch (NullPointerException e) {
            System.out.println("\nCannot add null key in Hashtable: " + e);
        }
    }
}