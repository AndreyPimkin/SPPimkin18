package musicAndPicture;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transforming {


    public static String transformLink(byte num){ //Метод для получения ссылки

        try(BufferedReader read = new BufferedReader(new FileReader(Main.INFO_TXT))){
            String line;
            String link = "";

            while ((line = read.readLine()) != null){
                if (num == 1){
                    Matcher matcher = Pattern.compile("(.*\\s)").matcher(line); // Регулярка для проверки ссылки
                    while(matcher.find()){
                        link = matcher.group();
                        num++;
                    }
                }

                else{
                    num--;
                }
            }
            return link;
        }

        catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }
    public static String transformPath(byte num){ //Метод для получения пути сохранения

        try(BufferedReader read = new BufferedReader(new FileReader(Main.INFO_TXT))){
            String line;
            String link = "";

            while ((line = read.readLine()) != null){
                if (num == 1){
                    Matcher matcher = Pattern.compile("(\\s.*)").matcher(line); // Регулярка для проверки пути
                    while(matcher.find()){
                        link = matcher.group();
                        num++;
                    }
                }

                else{
                    num--;
                }
            }
            return link;
        }

        catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    /* Метод для записи ссылок в файл. Пришлось его дописывать, чтобы работали методы скачивания,
       так как они считывают файлы.
     */
    public static void write(String link, byte num){

        if (num == 1){
            try (BufferedWriter wr = new BufferedWriter(new FileWriter(Main.INFO_PICTURE_TXT, false))) {
                wr.write(link + "\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else if (num == 2){
            try (BufferedWriter wr = new BufferedWriter(new FileWriter(Main.INFO_MUSIC_TXT, false))) {
                wr.write(link + "\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
