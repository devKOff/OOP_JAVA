class Car {
    // Attributes (fields)
    String model;
    int year;

    // Method
    void drive() {
        System.out.println(model + " is driving!");
    }
}


public class Main {
    public static void main(String[] args) {
        // Creating objects of the Car class
        Car myCar = new Car();
        myCar.model = "Toyota";  // Set attribute
        myCar.year = 2020;       // Set attribute
        myCar.drive();           // Call method, outputs: Toyota is driving!


    }
}