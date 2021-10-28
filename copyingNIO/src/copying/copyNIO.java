package copying;
import java.io.*;
import java.nio.channels.FileChannel;


public class copyNIO {
    public static void main(String[] args) throws IOException {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        copy(file1, file2);

    }
    private static void copy(File file1, File file2) throws IOException {
        FileChannel Channel1 = null;
        FileChannel Channel2 = null;
        long start = System.currentTimeMillis();
        try {
            Channel1 = new FileInputStream(file1).getChannel();
            Channel2 = new FileOutputStream(file2).getChannel();
            Channel2.transferFrom(Channel1, 0, Channel1.size());
        }finally{
            Channel1.close();
            Channel2.close();
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}