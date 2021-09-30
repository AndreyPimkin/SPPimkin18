import java.io.IOException;

public class potok {
    public static void main(String[] args) {
        try {

            final Process p = Runtime.getRuntime().exec("pt.bat");
            final int retCode = p.waitFor();
        }
        catch (IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


