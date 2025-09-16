// This code works for command line argument when
// we pass java AddNumber
// while typing java AddNumber we have to pass 2 input
// like given below
public class AddNumbser {
    public static void main(String[] args) {


            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            System.out.println("Sum: " + (num1 + num2));
        }
}
/*
Microsoft Windows [Version 10.0.26100.6584]
(c) Microsoft Corporation. All rights reserved.

E:\>set path=C:\Program Files\Java\jdk-24\bin

E:\>javac AddNumbser.java

E:\>java AddNumbser
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        at AddNumbser.main(AddNumbser.java:5)

E:\>java AddNumbser 33 22
Sum: 55.0

E:\>
E:\>
E:\>java AddNumbser 33 22
Sum: 55.0

E:\>

*/