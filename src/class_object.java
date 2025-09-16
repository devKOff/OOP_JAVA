// Define a class named Student
public class class_object {
    // Instance variables (attributes)
    String name;
    int[] marks;

    // Constructor to initialize the object
    public class_object(String studentName, int[] studentMarks) {
        name = studentName;
        marks = studentMarks;
    }

    // Method to calculate and return the average of marks
    public double calculateAverageMarks() {
        double sum = 0;
        for (int mark : marks) { // Using for-each loop (as per your earlier question)
            sum += mark;
        }
        return sum / marks.length;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Marks: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.printf("Average Marks: %.2f\n", calculateAverageMarks());
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create an array of marks for a student
        int[] studentMarks = {85, 90, 78, 92, 88};

        // Create an object of the Student class
        class_object student1 = new class_object("Alice", studentMarks);

        // Call the method to display details
        student1.displayDetails();
    }
}