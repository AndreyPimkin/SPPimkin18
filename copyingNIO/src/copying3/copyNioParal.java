package copying3;


import java.io.*;
import java.nio.channels.FileChannel;

public class copyNioParal extends Thread {
    String name;
    int priority;
    public copyNioParal(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        Thread.currentThread().setName(name);
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");
        FileChannel Channel1 = null;
        FileChannel Channel2 = null;
        FileChannel Channel3 = null;
        try {
            Channel1 = new FileInputStream(file1).getChannel();
            Channel2 = new FileOutputStream(file2).getChannel();
            Channel3 = new FileOutputStream(file3).getChannel();
            if(getName().equals("первый")){
                Channel2.transferFrom(Channel1, 0, Channel1.size());
            }
            else if(getName().equals("второй")){
                Channel3.transferFrom(Channel1, 0, Channel1.size());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                Channel1.close();
                Channel2.close();
                Channel3.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}