public class Name2 {
    public static void main(String[] args) {
        String str1 = "Dev";
        System.out.println("String 1 : " + str1);
        System.out.println(System.identityHashCode(str1));

        String str2 = str1.concat(" World");
        System.out.println("After : " + str1);
        System.out.println(System.identityHashCode(str1));
        System.out.println("String 2 : " + str2);
        System.out.println(System.identityHashCode(str2));
    }
}