package musicAndPicture;

public class Streams extends Thread {
    String name;
    public Streams(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        Thread.currentThread().setName(name);
        if (getName().equals("Музыка")){
            Music.downloadMusic(); // Вызов метода для скачивания музыки

        }
        else if(getName().equals("Картинка")) {
            Picture.downloadPicture(); // Вызов метода для скачивания картинки
        }
    }
}