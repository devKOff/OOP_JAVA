import java.util.*;

class SortBySalaryExample {
    public static void main(String[] args) {
        Map<String, Double> teacherSalaries = new HashMap<>();
        teacherSalaries.put("Amit", 55000.50);
        teacherSalaries.put("Priya", 45000.75);
        teacherSalaries.put("Vikas", 75000.00);
        teacherSalaries.put("Sneha", 60000.25);

        // Convert map entries to list and sort by salary
        List<Map.Entry<String, Double>> entryList = new ArrayList<>(teacherSalaries.entrySet());
        entryList.sort((e1, e2) -> Double.compare(e1.getValue(), e2.getValue()));

        // Print sorted entries
        System.out.println("Teachers sorted by salary:");
        for (Map.Entry<String, Double> entry : entryList) {
            System.out.println("Teacher: " + entry.getKey() + ", Salary: " + entry.getValue());
        }
    }
}