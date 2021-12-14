package packageObfuscator;

import java.io.*;

public class Merger { // Данный класс соединяет все файлы в один для удобства
        public static void mergeСode () {
            String[] arrayFile = new String[7];
            arrayFile[0] = "Main.txt";
            arrayFile[1] = "Streams.txt";
            arrayFile[2] = "Music.txt";
            arrayFile[3] = "Picture.txt";
            arrayFile[4] = "Transforming.txt";
            arrayFile[5] = "Open.txt";
            arrayFile[6] = "Helping.txt";
            readerAll(arrayFile);

        }
    public static void readerAll(String[] arrayFile) { // Считывает строчки из файла
        for (int i = 0; i < 7; i++) {
            try (BufferedReader read = new BufferedReader(new FileReader(arrayFile[i]))) {
                String line;
                while ((line = read.readLine()) != null) {
                    writeAll(line);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeAll(String line){ // Метод для записи строки
        try(BufferedWriter wr = new BufferedWriter(new FileWriter("gap.txt", true))){
            wr.write(line + "\n");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
