package packageObfuscator;
import java.util.Random;

public class RandomName { // Почти рандом
    public static int i = 0;
    public static String shortName = "";

    public static String nameClass() {
        char randomSymbol;
        Random r = new Random();
        while (i < 100){
            randomSymbol = (char) (90 - r.nextInt(25));
            shortName = randomSymbol + String.valueOf(i);
            i++;
            break;
        }
        return shortName;
    }
    public static String nameMethodAndVar() {
        char randomSymbol;
        Random r = new Random();
        while (i < 100){
            randomSymbol = (char) (122 - r.nextInt(25));
            shortName = randomSymbol + String.valueOf(i);
            i++;
            break;
        }
        return shortName;
    }
}
