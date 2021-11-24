package musicAndPicture;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Music {

    public static void downloadMusic(){
        byte num = 2; // Это число нужно для определения: музыка ли или картинка.
        String link = Transforming.transformLink(num); // Для получения ссылки
        String path = Transforming.transformPath(num); // Для получения пути
        Transforming.write(link, num); // Записывает ссылку обратно

        String Url;
        try (BufferedReader inFile = new BufferedReader(new FileReader(Main.INFO_MUSIC_TXT));
             BufferedWriter outFile = new BufferedWriter(new FileWriter(Main.OUT_TXT))) {
            while ((Url = inFile.readLine()) != null) {
                URL url = new URL(Url);

                String result;
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                    result = bufferedReader.lines().collect(Collectors.joining("\n"));
                }
                Pattern email_pattern = Pattern.compile("\\s*(?<=data-url\\s?=\\s?\")[^>]*\\/*(?=\")");
                Matcher matcher = email_pattern.matcher(result);
                int i = 0;
                while (matcher.find() && i < 1) {
                    outFile.write(matcher.group() + "\r\n");
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader musicFile = new BufferedReader(new FileReader(Main.OUT_TXT))) {
            String music;
            int count = 0;
            try {
                while ((music = musicFile.readLine()) != null) {
                    assert path != null; // Без этой строчки ругается Intellij Idea
                    downloadUsingNIO(music, path.trim() + String.valueOf(count) + ".mp3"); // .trim убирает пробелы
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void downloadUsingNIO(String strUrl, String file) throws IOException {
        URL url = new URL(strUrl);
        ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
        FileOutputStream stream = new FileOutputStream(file);
        stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
        stream.close();
        byteChannel.close();
    }
}