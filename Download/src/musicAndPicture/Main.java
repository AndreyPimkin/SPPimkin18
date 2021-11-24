package musicAndPicture;



public class Main {

    public static final String INFO_TXT = "C:\\Users\\pimki\\IdeaProjects\\Download\\info.txt"; // Файл с ссылками на сайты и пути сохранения
    public static final String OUT_TXT = "out.txt"; // Файл для вывода
    public static final String INFO_MUSIC_TXT = "infoMusic.txt"; // Файл для ссылки музыки
    public static final String INFO_PICTURE_TXT = "infoPicture.txt"; // Файл дял ссылки картинки

    public static void main(String[] args) {
        Streams  music = (new Streams("Музыка"));
        Streams picture = (new Streams("Картинка"));
        music.start(); // запускает поток для скачивания музыки
        picture.start(); // запусакет поок для скачивания картинки
        while (true){

            if (!picture.isAlive()){ // Проверяет, скачались ли песня и картинки
                System.out.println("Картинка скачалась");
                break;
            }
        }
        while (true){

            if (!music.isAlive()){ // Проверяет, скачались ли песня и картинки
                System.out.println("Музыка скачалась");
                break;
            }
        }
        while (true){

            if (!music.isAlive() && !picture.isAlive()){ // Проверяет, скачались ли песня и картинки
                System.out.println("Сейчас прослушаем песню");
                Open.openMusic(); // открывает метод для заупска песни
                break;
            }
        }

    }

}

