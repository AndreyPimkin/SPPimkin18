package animals;
public class AnimalThread extends Thread {
    String name;
    int priority;
    int dins = 60;
    public AnimalThread(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        Thread.currentThread().setName(name);
        int timeToStep = 900 / (Thread.currentThread().getPriority());
        for (int i = 1; i < dins; i++) {
            try {
                Thread.sleep(timeToStep);
                System.out.println(getName() + " пробежал/а " + i + " метров ");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == dins / 3) {
                if (Thread.currentThread().getPriority() == 1) {
                    Thread.currentThread().setPriority(10);
                }
                else {
                    Thread.currentThread().setPriority(1);
                }
                timeToStep = 900 / (Thread.currentThread().getPriority());
                System.out.println("\n" + "Черепаха ускорилась , а кролик устал" + "\n");
            }
            if (i == dins - 1) {
                System.out.println("Финиш");

            }
        }
    }
}

