package copying;

import java.io.*;

public class copy {
    public static void main(String[] args) throws IOException {
        File fileOne = new File("copy1.txt");
        File fileTwo = new File("copy2.txt");
        copyFileUsingStream(fileOne, fileTwo);
    }
    private static void copyFileUsingStream(File fileOne, File fileTwo) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        long start = System.currentTimeMillis();
        try {
            is = new FileInputStream(fileOne);
            os = new FileOutputStream(fileTwo);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
        finally {
            is.close();
            os.close();
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}