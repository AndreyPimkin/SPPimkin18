package musicAndPicture;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.IOException;

public class Open {
    public static void openMusic() {
        try (FileInputStream inputStream = new FileInputStream("DownloadFiles0.mp3")) {
            try {
                Player player = new Player(inputStream);
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
