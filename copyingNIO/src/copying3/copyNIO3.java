package copying3;

public class copyNIO3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        copyNioParal copyOne = (new copyNioParal("первый", 5));
        copyNioParal copyTwo = (new copyNioParal("второй", 5)) ;
        copyOne.start();
        copyTwo.start();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}

