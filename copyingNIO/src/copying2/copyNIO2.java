package copying2;
import java.io.*;
import java.nio.channels.FileChannel;

public class copyNIO2 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");
        File file4 = new File("file4.txt");
        copy(file1, file2 ,file3, file4);
    }
    private static void copy(File file1, File file2, File file3, File file4) throws IOException {
        FileChannel Channel1 = null;
        FileChannel Channel2 = null;
        long start = System.currentTimeMillis();
        try {
            Channel1 = new FileInputStream(file1).getChannel();
            Channel2 = new FileOutputStream(file2).getChannel();
            Channel2.transferFrom(Channel1, 0, Channel1.size());
        }
        finally{
            Channel1.close();
            Channel2.close();
        }

        //////

        FileChannel Channel3 = null;
        FileChannel Channel4 = null;
        try {
            Channel3 = new FileInputStream(file3).getChannel();
            Channel4 = new FileOutputStream(file4).getChannel();
            Channel4.transferFrom(Channel3, 0, Channel3.size());
        }finally{
            Channel3.close();
            Channel4.close();
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
