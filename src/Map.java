import java.util.*;

class TeacherMapExample {
    public static void main(String[] args) {
        // Create a HashMap to store teacher names and their salaries
        Map<String, Double> teacherSalaries = new HashMap<>();

        // 1. Adding key-value pairs to the map
        teacherSalaries.put("Amit", 55000.50);
        teacherSalaries.put("Priya", 45000.75);
        teacherSalaries.put("Vikas", 75000.00);
        teacherSalaries.put("Sneha", 60000.25);
        teacherSalaries.put("Rohan", 40000.00);

        // 2. Printing the entire map
        System.out.println("Teacher Salaries: " + teacherSalaries);

        // 3. Retrieving a specific teacher's salary
        String teacherName = "Priya";
        if (teacherSalaries.containsKey(teacherName)) {
            System.out.println(teacherName + "'s salary: " + teacherSalaries.get(teacherName));
        } else {
            System.out.println(teacherName + " not found in the map.");
        }

        // 4. Updating a teacher's salary
        teacherSalaries.put("Amit", 58000.00); // Update Amit's salary
        System.out.println("After updating Amit's salary: " + teacherSalaries.get("Amit"));

        // 5. Removing a teacher
        teacherSalaries.remove("Rohan");
        System.out.println("After removing Rohan: " + teacherSalaries);

        // 6. Iterating over the map using entrySet()
        System.out.println("\nAll Teachers and Salaries:");
        for (Map.Entry<String, Double> entry : teacherSalaries.entrySet()) {
            System.out.println("Teacher: " + entry.getKey() + ", Salary: " + entry.getValue());
        }

        // 7. Iterating over keys only
        System.out.println("\nTeacher Names:");
        for (String name : teacherSalaries.keySet()) {
            System.out.println(name);
        }

        // 8. Iterating over values only
        System.out.println("\nSalaries:");
        for (Double salary : teacherSalaries.values()) {
            System.out.println(salary);
        }

        // 9. Checking size of the map
        System.out.println("\nNumber of teachers: " + teacherSalaries.size());

        // 10. Adding a null key (allowed in HashMap)
        teacherSalaries.put(null, 50000.00);
        System.out.println("After adding null key: " + teacherSalaries);
    }
}