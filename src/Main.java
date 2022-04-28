import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("C://bob//first.txt");
            fos.write("Hello interesting".getBytes());
            System.out.println("Файл first записан");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            FileOutputStream fos1 = new FileOutputStream("C://bob//second.txt");
            fos1.write("and wonderful world!".getBytes());
            System.out.println("Файл second записан");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream("C://bob//first.txt")) {
            System.out.println(fis.available());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileInputStream fis = new FileInputStream("C://bob//second.txt")) {
            System.out.println(fis.available());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        copyFiles("C://bob//first.txt","C://bob//second.txt");
    }

    static public void copyFiles(String first, String second) throws IOException {
        Reader fis = new FileReader("C://bob//second.txt");
        Writer fos = new FileWriter("C://bob//first.txt", true);
        char[] buffer = new char[1024];
        int lengt;
        while ((lengt = fis.read(buffer)) > 0){
            fos.append('\n');
            fos.write(buffer,0,lengt);
            fos.write(" ");
            fos.write(String.valueOf(lengt));
        }
        fis.close();
        fos.close();

    }


}


