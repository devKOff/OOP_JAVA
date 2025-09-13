

public class Objects {
    public static void main(String[] args) {

        Car myCar = new Car();
        System.out.println(myCar.price); // calling attributes.

        // calling the method will give everything in the method.
        myCar.Drive();
        myCar.nDrive();

        // all these method are from the Car class(Car.java)
        // the .java file should be in same folder .


    }
}