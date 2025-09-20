class Parents{
    int x;
    Parents(){
        this.x=1;
        System.out.println("parents");

    }
    public Parents(int x){
        this.x = x;
        System.out.println("Parents constructor");

    }

}

class Child extends Parents{
    int y;
    Child(){
        this(5);
        System.out.println("child");
    }
    public Child(int y){
        super(5);
        this.y = y;
        System.out.println("Child constructor");
    }

}

public class work{
    public static void main(String[] args) {
        Parents a = new Child();
        Child b = new Child();


    }
}