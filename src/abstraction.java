// Abstraction in Java (often associated with Object-Oriented Programming, or OOP)
// is a concept that allows you to hide complex implementation details and expose
// only the necessary parts of an object to the user.

abstract class Bank {
    abstract double getRateOfInterest();
}

class SBI extends Bank{
    double getRateOfInterest(){
        return -1.00;
    }

}