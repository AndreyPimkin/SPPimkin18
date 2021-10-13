package animals;


public class AnimalThread extends Thread {
    String name;
    int priority;
    public AnimalThread(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        Thread.currentThread().setName(name);
        int Sleep = 900 / (Thread.currentThread().getPriority());
        for (int j = 0; j < 3; j++){
            if(getName().equals("Кролик")){
                switch (j){
                        case (0):
                            System.out.println("На старт!!!!"+ "\n");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case (1):
                            System.out.println("Внимание!!!!"+ "\n");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case (2):
                            System.out.println("Марш!!!!"+ "\n");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                }
            }
            else if(getName().equals("Черепаха")){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 1; i < 60; i++) {
            if(getName().equals("Кролик")){
                try {
                    if(i < 20){
                        Thread.sleep(Sleep);
                        System.out.println(getName() + " пробежал " + i + " метров ");
                    }
                    else if (i < 50){
                        Thread.sleep(Sleep);
                        System.out.println(getName() + " прошел " + i + " метров ");
                    }
                    else{
                        Thread.sleep(Sleep);
                        System.out.println(getName() + " прополз " + i + " метров ");
                    }

                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    if(i < 15){
                        Thread.sleep(Sleep);
                        System.out.println(getName() + " прошла " + i + " метров ");
                    }
                    else if (i < 40){
                        Thread.sleep(Sleep);
                        System.out.println(getName() + " пробежала " + i + " метров ");
                    }
                    else{
                        Thread.sleep(Sleep);
                        System.out.println(getName() + " пролетела " + i + " метров ");
                    }

                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (i == 20 && getName().equals("Кролик")){
                System.out.println("__________Кролик устал_________"+"\n");
                Thread.currentThread().setPriority(2);
                Sleep = 900 / (Thread.currentThread().getPriority());
            }
            if (i == 50 && getName().equals("Кролик")){
                System.out.println("______Кролик очень сильно устал_____"+"\n");
                Thread.currentThread().setPriority(1);
                Sleep = 900 / (Thread.currentThread().getPriority());
            }
            if (i == 15 && getName().equals("Черепаха")){
                System.out.println("............Черепаха набралась сил и ускорилась............"+"\n");
                Thread.currentThread().setPriority(5);
                Sleep = 900 / (Thread.currentThread().getPriority());
            }
            if (i == 40 && getName().equals("Черепаха")){
                System.out.println(".............Черепаха включила турборежим..........."+"\n");
                Thread.currentThread().setPriority(10);
                Sleep = 900 / (Thread.currentThread().getPriority());
            }
            if (i == 59  && getName().equals("Кролик")) {
                System.out.println("______Кролик кое-как дошел__________" + "\n");
            }
            if (i == 59  && getName().equals("Черепаха")) {
                System.out.println("............Черепаха прибежала первой..............." + "\n");
            }
        }
    }
}

