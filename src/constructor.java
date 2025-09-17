// A constructor in Java is a special method used to initialize objects.
// It's called automatically when a new object is created. The main purpose of
// a constructor is to set initial values for the object's instance variables.
class B{
    A obj;
    public void getRef(A obj1){
        obj = obj1;
    }
}

class A{
    int x,y;
    A(){
        this(2,6);
        System.out.println("Constructor");
    }
    A(int x,int y){

        this.x=x;
        this.y=y;
        System.out.println("Parameterized Constructor");
        this.m1();
    }
    public void m1(){
        System.out.println("m1()");
    }
}
public class constructor {
    public static void main(String[] args) {
        A a=new A();
        A a1=new A(2,3);
        a1.m1();

    }
}
/*       OUTPUT
Parameterized Constructor
m1()
Constructor
Parameterized Constructor
m1()
m1()
 */