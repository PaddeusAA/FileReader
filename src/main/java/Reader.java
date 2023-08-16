import java.io.*;
import java.util.Scanner;

public class Reader {

    private String fileName;
    private int action;
    Scanner in = new Scanner(System.in);

    public void start() {
        System.out.println("Приложение для работы с файлом\n " +
                "Вот что я могу " +
                "\n1) Вывести текст файла на экран " +
                "\n2) Перезапись или добовления нового текста в существующий или новый файл");
        action = in.nextInt();

        switch (action) {
            case 1 -> fileTextOutput();
            case 2 -> fileTextInput();
            default -> {
            }
        }
    }

    //метод вывода текста из указанного пользователем файле
    private void fileTextOutput() {

        System.out.println("Для вывода введите имя файла c его расширением\n");

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

    //метод перезаписи или добовления текста в новом или уже существующем файле
    private void fileTextInput() {
        System.out.println("Для записи введите имя существующего файла c его расширением " +
                "\n\tили напишите название нового файла\n");

        fileName = in.next();

        System.out.println("Вы хотите 1) Добавить текст 2) Перезаписать");

        int action = in.nextInt();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            if (action == 1) {
                System.out.println("Начните писать текст, для останвки напишите stopWrite\n");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                    String line;

                    while (!(line = reader.readLine()).equals("stopWrite")) {
                        writer.write(line);
                    }
                }
            } else if (action == 2) {
                System.out.println("Начните писать текст, для останвки напишите stopWrite\n");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                    String line;

                    while (!(line = reader.readLine()).equals("stopWrite")) {
                        writer.write(line);
                    }
                }
            }else {
                System.err.println("Ошибка ввода");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

