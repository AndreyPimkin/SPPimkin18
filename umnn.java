package umn;
import java.util.Scanner;

public class umnn {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число");
        int N = in.nextInt();
        System.out.println("Введите второе число");
        int M = in.nextInt();
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
