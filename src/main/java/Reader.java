import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

    String fileName;
    Scanner in = new Scanner(System.in);

    public void start() {
        fileReader();
    }

    private void fileReader() {

        System.out.println("Введите имя файла и его расширение\n");

        fileName = in.next();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("\n" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

