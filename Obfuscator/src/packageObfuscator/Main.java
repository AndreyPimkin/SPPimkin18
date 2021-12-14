package packageObfuscator;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    /*
     * Содержит имена пакетов.
     * Их легче было самому написать
     */
    public static String string = "import java.io.*; import java.util.regex.Matcher; " +
            "import java.util.regex.Pattern; import java.lang.annotation.ElementType; import java.lang.annotation.Target; " +
            "import java.net.URL; import java.nio.channels.Channels; import java.nio.channels.ReadableByteChannel; " +
            "import java.util.stream.Collectors; import javazoom.jl.decoder.JavaLayerException; import javazoom.jl.player.Player;";
    public static ArrayList<String> classNames = new ArrayList<>(); // Массив, который будет содержать имена классов
    public static ArrayList<String> methodNames = new ArrayList<>(); // Массив, который будет содержать имена методов
    public static ArrayList<String> varNames = new ArrayList<>(); // Массив, который будет содержать имена переменных


    public static void main(String[] args) {
        String arrayFile = "gap.txt";
        reader(arrayFile); //Метод нужен для чтения файлов
        Set<String> varSet = new HashSet<>(varNames); // Чтобы убрать одинаковые имена переменных
        varNames.clear(); // Очищает список
        varNames.addAll(varSet); // Заполняет список
        Selection.changeName();
        write(string);
        //Merger.mergeСode(); // Метод записывает все в один файл. Запускать 1 раз.

     }



    public static void reader(String arrayFile) { //Считывает строчки из файла
        try (BufferedReader read = new BufferedReader(new FileReader(arrayFile))) {
            String line;
            while ((line = read.readLine()) != null) {
                line = Selection.removeOneLineComment(line);
                line = Selection.removeMultilineComment(line);
                line = Selection.removeDuplication(line);
                Selection.getOldNameClass(line);
                Selection.getOldNameMethod(line);
                Selection.getOldNameVar(line);
                line = Selection.removeSpace(line);
                Selection.removeParagraph(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void write(String line){ //Метод для записи строки
        try(BufferedWriter wr = new BufferedWriter(new FileWriter("final.txt", true))){
            wr.write(line + "\n");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}