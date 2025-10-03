/*
 * This program demonstrates using LinkedList from Java Collections Framework
 * to store and iterate over a list of Employee objects.
 * Each Employee holds name, age, and salary details, and we override toString()
 * for readable output when printing. This showcases OOP (Object-Oriented Programming)
 * concepts like classes, objects, encapsulation, and collections for managing groups of data.
 *
 * Key Concepts (Meanings):
 * - Class: A blueprint for creating objects (e.g., Employee defines structure for employee records).
 * - Object: An instance of a class with actual values (e.g., s1 is one employee's data).
 * - LinkedList: A dynamic data structure (part of Collections Framework) that stores elements in sequence,
 *   allowing efficient addition/removal. It's like a chain of nodes where each points to the next.
 * - Iterator: An object that enables sequential traversal of a collection without exposing its internals.
 *   It provides hasNext() to check if more elements exist and next() to fetch the next one.
 * - Generics: Type parameters (e.g., <Employee>) ensure type safety, preventing runtime errors from wrong types.
 * - toString(): A method overridden to return a custom string representation of an object for easy printing.
 */

import java.util.*;  // Import for LinkedList, Iterator, and other utilities from java.util package

class Employee {  // Custom class to represent employee information (encapsulates data and behavior)
    String name;  // Field for employee's name (String type for text data)
    int age;      // Field for employee's age (int for whole numbers)
    double salary; // Field for employee's salary (double for decimal values like 50000.50)

    // Constructor: Special method to initialize object fields when creating a new instance
    // 'this' keyword refers to the current object to distinguish from parameters
    Employee(String n, int a, double sal) {
        this.name = n;     // Assign parameter to instance variable
        this.age = a;      // Meaning: Sets the age value for this employee object
        this.salary = sal; // Meaning: Sets the salary value, allowing for floating-point precision
    }

    // Override toString() method: Inherited from Object class; provides a human-readable string
    // This is called automatically when using System.out.println() on the object
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Salary: $" + salary;
    }
}

public class listCollection2 {  // Main class containing the program's entry point (main method)
    public static void main(String[] args) {  // static: Belongs to class, not instance; main is the JVM's starting point
        // Create three Employee objects (instantiation using 'new' keyword)
        Employee e1 = new Employee("Rajiv", 34, 75000.00);  // Object 1: Senior employee
        Employee e2 = new Employee("Dev", 20, 45000.00);    // Object 2: Junior developer
        Employee e3 = new Employee("Alice", 28, 60000.00);  // Object 3: Mid-level manager

        // Declare and initialize a LinkedList to hold Employee objects
        // Meaning: LinkedList is resizable; grows/shrinks dynamically unlike fixed-size arrays
        // Generics (<Employee>) ensure only Employee objects can be added (compile-time check)
        LinkedList<Employee> employees = new LinkedList<Employee>();

        // Add employees to the list using add() method
        // Meaning: Appends to the end; order is preserved (FIFO-like for lists)
        employees.add(e1);  // Adds Rajiv's object
        employees.add(e2);  // Adds Dev's object
        employees.add(e3);  // Adds Alice's object

        // Get an iterator for safe, sequential traversal of the list
        // Meaning: Iterator acts like a cursor; prevents ConcurrentModificationException if modifying during loop
        Iterator<Employee> it = employees.iterator();  // Typed for generics (no casting needed)

        // Loop through the iterator: While more elements exist, print the next one
        // Meaning: This is a fail-safe way to iterate; 'while' checks condition before body executes
        while (it.hasNext()) {  // hasNext(): Returns true if there's at least one more element
            System.out.println(it.next());  // next(): Retrieves and advances to the next element; calls toString()
        }
    }
}