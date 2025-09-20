class Student {
    String name;
    int roll;

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }
}

public class array {

    public void printArray(Student[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.println("Name: " + arr[i].name + ", Roll: " + arr[i].roll);
        }
    }

    public static void main(String[] args) {
        array c = new array();
        Student arr[] = new Student[3];
        arr[0] = new Student("Driver", 1);
        arr[1] = new Student("piper", 2);
        arr[2] = new Student("civer", 3);
        c.printArray(arr);
    }
}