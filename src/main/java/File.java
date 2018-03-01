import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File {

    public static String read (String path) {
        String string = null;
        System.out.print("Trying to read file - " + path + " - ");
        try {
            FileInputStream stream = new FileInputStream(path);
            Scanner scanner = new Scanner(stream);
            string = scanner.next();
            System.out.println("done");
            System.out.println(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("failed");
        }
        return string;
    }

    public static void write (String path, String string) {
        System.out.print("Trying to write file - " + path + " - ");
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(string);
            writer.flush();
            writer.close();
            System.out.println("done");
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed");
        }

    }
}
