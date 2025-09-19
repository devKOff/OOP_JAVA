class rectangle {
    public int Area(int a,int b){
        return a*b;
    }
    public int Perimeter(int a,int b){
        return 2*(a+b);
    }

}

public class areacalculotor {


    public static void main(String[] args) {
        rectangle obj = new rectangle();
        System.out.println(obj.Area(3,4));
        System.out.println(obj.Perimeter(3,4));

    }
}
