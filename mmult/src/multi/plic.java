package multi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class plic {
    public static void main(String[] args){
        reader();
    }
    public static void reader(){
        try(BufferedReader read = new BufferedReader(new FileReader("chet.txt"))){
            String N_1 = "";
            String M_1 = "";
            int i = 0;
            String Line = read.readLine();
            Matcher matcher = Pattern.compile("(\\d+)").matcher(Line);
            while(matcher.find()){
                if(i == 0){
                    N_1 = matcher.group();
                    i++;
                }
                M_1 = matcher.group();
            }
            Multiplication multiplication = new Multiplication();
            System.out.println(multiplication.Mul(Integer.parseInt(N_1), Integer.parseInt(M_1)));

        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
class Multiplication {
    static long Mul(int N, int M){
        if (N == 0)
            return 0;
        if (N == 1)
            return M;
        long res;
        res = Mul(N / 2, M);
        if (N % 2 == 0)
            return res + res;
        else
            return res + res + M;
    }
}