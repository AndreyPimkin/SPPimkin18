package packageObfuscator;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Selection {
    private static boolean found; // проверка условия
    private static String methodOldName; // Старое имя метода
    private static Pattern pattern;
    private static Matcher matcher;


    public static String removeOneLineComment(String line){
        Pattern pattern = Pattern.compile("//[^\\r\\n]*$");
        Matcher matcher = pattern.matcher(line);
        line = matcher.replaceAll("");
        return line;
    }
    public static String removeMultilineComment(String line) {
        /*
         * В моем коде 1 многострочный комментарий, поэтому для него подойдет
         * и регулярка ниже.
         */
        Pattern pattern = Pattern.compile("^(.*/\\*.*)|(.*\\*/)|так как они считывают файлы.$");
        Matcher matcher = pattern.matcher(line);
        line = matcher.replaceAll("");
        return line;

    }
    public static String removeDuplication(String line){
        /*
         * Так как я все запихал в один файл, пакет уже потерял свою актуальность.
         * Импорты дял некоторых классов повторяются, поэтому лучше их удалить, а потом записать нужные.
         */
        line = line.replaceAll("package musicAndPicture;", ""); // удаляет имена пакетов
        line = line.replaceAll("import.*", ""); // удаляет импорты
        return line;

    }
    public static String removeSpace(String line){
        /*
         * Заменяет пробелы >1 на одиночный пробел.
         */
        line = line.replaceAll("( )+", " ");
        return line;
    }
    public static void removeParagraph(String line){
        /*
         * Записывает все строки в одну удобства и сокращения.
         */
        Main.string += line;
    }


    public static void getOldNameClass(String line){
        /*
         * Имя класса Main не затрагивается.
         */
        pattern = Pattern.compile("class.*"); // Ищет классы
        matcher = pattern.matcher(line);
        found = matcher.find();
        if(found) {
            pattern = Pattern.compile("Main"); // Проверяет на класс Main
            matcher = pattern.matcher(line);
            found = matcher.find();
            if(!found){
                matcher = Pattern.compile("\\bclass\\s+([^\\s {]+)").matcher(line); // Регулярка для получения имени класса
                while(matcher.find()){
                    // Старое имя класа
                    String classOldName = matcher.group(1); // Старое имя класса
                    ListName.getNameClass(classOldName);
                }
            }
        }
    }

    public static void getOldNameMethod(String line){
        /*
         * Имя метода main и run не затрагивается.
         */
        pattern = Pattern.compile("\\bvoid\\s+([^\\s(]+)"); // Ищет методы void
        matcher = pattern.matcher(line);
        found = matcher.find();
        if(found) {
            pattern = Pattern.compile("\\bvoid\\s+([^\\s(]+)"); 
            matcher = pattern.matcher(line);
            while(matcher.find()){
                methodOldName = matcher.group(1);
            }

            if (!(methodOldName.equals("main") || methodOldName.equals("run"))){
                ListName.getNameMethod(methodOldName);
            }
        }
        /*
         * Ищет классы String. С переменными не перепутает, так как у меня там еще final и скобка.
         * public static final String - переменные
         * public static String( - методы
         */
        pattern = Pattern.compile("\\bstatic String\\s+([^\\s(]+)"); // Ищет методы String
        matcher = pattern.matcher(line);
        found = matcher.find();
        if(found) {
            pattern = Pattern.compile("\\bstatic String\\s+([^\\s(]+)"); 
            matcher = pattern.matcher(line);
            while(matcher.find()){
                methodOldName = matcher.group(1);
            }
            ListName.getNameMethod(methodOldName);
        }

    }

    public static void getOldNameVar(String line){
        /*
         * i и j лучше не менять. Эту регулярку мне доработал один человек с форума.
         * Другие регулярки упускали некоторые переменные или же выводили лишнее.
         */
        pattern = Pattern.compile("\\b([\\w<>\\[\\]]+)\\s+(\\w+)\\s*[;=:]"); // Ищет переменные
        matcher = pattern.matcher(line);
        found = matcher.find();
        String varOldName = "";
        if(found) {
            pattern = Pattern.compile("([\\w<>\\[\\]]+)\\s+(\\w+)\\s*[;=:]");
            matcher = pattern.matcher(line);
            while(matcher.find()){
                varOldName = matcher.group(2); // Старое имя переменной
            }
            if (!(varOldName.equals("i") || varOldName.equals("j"))){
                ListName.getNameVar(varOldName);
            }
        }
    }
    public static void changeName(){
        for(int i = 0; i < Main.classNames.size(); i ++){ // Меняет имена классов со всеми объектами
            Main.string = Main.string.replace(Main.classNames.get(i), RandomName.nameClass());
            System.out.println(Main.classNames.get(i));
        }
        for(int i = 0; i < Main.methodNames.size(); i ++){ // Меняет имена классов со всеми объектами
            Main.string = Main.string.replace(Main.methodNames.get(i), RandomName.nameMethodAndVar());
            System.out.println(Main.methodNames.get(i));
        }
        for(int i = 0; i < Main.varNames.size(); i ++){ // Меняет имена классов со всеми объектами
            Main.string = Main.string.replace(Main.varNames.get(i), RandomName.nameMethodAndVar());
        }
        Main.string = Main.string.replace("Helping", "AN");

    }

}
