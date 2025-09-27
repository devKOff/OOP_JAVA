class Th2 extends Thread {
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println("2 * "+i+" = "+2*i);
            System.out.println(Thread.currentThread().getName());
        }
    }

}
class Th3 extends Thread {
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println("3 * "+i+" = "+3*i);
            System.out.println(Thread.currentThread().getName());
        }
    }

}


public class thread2 {
    public static void main(String[] args) {
        Th2 t2 = new Th2();
        Th3 t3 = new Th3();
        t2.setPriority(1);
        t3.setPriority(2);
        t2.start();
        t3.start();




    }
}
