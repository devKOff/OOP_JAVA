import java.util.*;

class Teacher {
    String name;
    double salary;

    Teacher(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class SalaryComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher t1, Teacher t2) {

        if (t1.getSalary() == t2.getSalary()) {
            return t1.getName().compareTo(t2.getName());
        }
        return Double.compare(t1.getSalary(), t2.getSalary());
    }
}

class TeacherSort {
    public static void main(String args[]) {
        SalaryComparator sc = new SalaryComparator();
        Teacher t1 = new Teacher("Amit", 55000.50);
        Teacher t2 = new Teacher("Priya", 45000.75);
        Teacher t3 = new Teacher("Vikas", 75000.00);
        Teacher t4 = new Teacher("Sneha", 60000.25);
        Teacher t5 = new Teacher("Rohan", 40000.00);
        Teacher t6 = new Teacher("Meena", 65000.30);

        TreeSet<Teacher> ts = new TreeSet<>(sc);
        ts.add(t1);
        ts.add(t2);
        ts.add(t3);
        ts.add(t4);
        ts.add(t5);
        ts.add(t6);

        // Use generics for Iterator
        Iterator<Teacher> it = ts.iterator();
        while (it.hasNext()) {
            Teacher t = it.next();
            System.out.println(t.getName() + " " + t.getSalary());
        }
    }
}