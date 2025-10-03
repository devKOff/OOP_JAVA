import java.util.*;

class student {
    String name;
    int age;
    int erp;

    student(String name, int age, int erp) {
        this.name = name;
        this.age = age;
        this.erp = erp;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", ERP: " + erp;
    }
}

public class listCollection {
    public static void main(String[] args) {
        LinkedList<student> al = new LinkedList<student>();
        al.add(new student("Alice", 20, 101));
        al.add(new student("Bob", 21, 102));
        al.add(new student("Charlie", 19, 103));


        Iterator<Student> it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}