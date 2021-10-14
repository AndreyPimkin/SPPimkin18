package disp;

public class Dispute {
    public static void main(String[] args) {
        Discussion chicken = (new Discussion("Курица", 5));
        Discussion egg = (new Discussion("Яйцо", 5));
        chicken.start();
        egg.start();
        String win = "";
        while (true){
            if (egg.isAlive() && !chicken.isAlive()){
                win = "Яйцо победило";
                break;
            }
            else if(!egg.isAlive() && chicken.isAlive()){
                win = "Курица победила";
                break;
            }
        }

        try {
            chicken.join();
            egg.join();
            System.out.println(win);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}