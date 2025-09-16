public class loop {
    public static void main(String[] args) {

        int[] marks = new int[5];

        marks[0] = 85;
        marks[1] = 92;
        marks[2] = 78;
        marks[3] = 95;
        marks[4] = 88;

        System.out.println("Marks of 5 students:");
        int studentNumber = 1;
        for (int mark : marks) {
            System.out.println("Student " + studentNumber + ": " + mark);
            studentNumber++;
        }
    }
}