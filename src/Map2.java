import java.util.*;

class Map2 {
    public static void main(String[] args) {
        // Create a TreeMap to store teacher names and their salaries (sorted by name)
        Map<String, Double> teacherSalaries = new TreeMap<>();

        // Adding key-value pairs
        teacherSalaries.put("Amit", 55000.50);
        teacherSalaries.put("Priya", 45000.75);
        teacherSalaries.put("Vikas", 75000.00);
        teacherSalaries.put("Sneha", 60000.25);
        teacherSalaries.put("Rohan", 40000.00);

        // Iterating over the map (keys are sorted alphabetically)
        System.out.println("Teachers sorted by name:");
        for (Map.Entry<String, Double> entry : teacherSalaries.entrySet()) {
            System.out.println("Teacher: " + entry.getKey() + ", Salary: " + entry.getValue());
        }
    }
}