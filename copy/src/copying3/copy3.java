package copying3;

public class copy3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        copyParal copyOne = (new copyParal("первый", 5));
        copyParal copyTwo = (new copyParal("второй", 5)) ;
        copyOne.start();
        copyTwo.start();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}