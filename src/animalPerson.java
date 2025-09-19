public class animalPerson {
    public class AnimalEat{
        void eat(){
            System.out.println("Animal is eating");
        }
    }
    class Dog extends AnimalEat{
        void speak1(){
            System.out.println("Dog is barking");
        }
    }
    class Babydog extends Dog{
        void speak2(){
            System.out.println("Babydog is weeping");
        }
    }

    public static void main(String[] args) {
        AnimalEat newAnimalEat = new animalPerson().new AnimalEat();
        newAnimalEat.eat();
        Dog newAn = new animalPerson().new Dog();
        newAn.speak1();
        Dog ne = new animalPerson().new Babydog();
        ne.eat();
    }
}
