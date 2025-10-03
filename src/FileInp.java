import java.io.*;

class FileInp {
    public static void main(String[] args) {
        try {
            File f = new File("f4.txt");
            f.createNewFile();


        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
