import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class multy {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String Line = in.nextLine();
        String N_1 = "";
        String M_1 = "";
        int i = 0;
        Matcher matcher = Pattern.compile("(\\d+)").matcher(Line);
        while(matcher.find()){
            if(i ==0){
                N_1 = matcher.group();
                i++;
            }
            M_1 = matcher.group();
        }
        int N = Integer.parseInt(N_1);
        int M = Integer.parseInt(M_1);

        System.out.println(Mul(N, M));
    }

    static long Mul(int N, int M) {

        if (N == 0)
            return 0;
        if (N == 1)
            return M;
        long res;
        res = Mul(N / 2, M);
        if (N % 2 == 0)
            return res+res;
        else
            return res+res+M;
    }
}
