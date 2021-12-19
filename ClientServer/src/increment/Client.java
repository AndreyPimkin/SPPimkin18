package increment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;



public class Client {

    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.0.1", 8080);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            int sms = 1;
            outputStream.write(sms);
            System.out.println("Серверу отправлено: " + sms);

            while ((sms = inputStream.read()) != -1) {
                System.out.println("Сервер прислал: " + sms);

                if (sms >= 20) {
                    break;
                }

                outputStream.write(++sms);
                System.out.println("Серверу отправлено: " + sms);
                outputStream.flush();
            }
            System.out.println("Устройство отключено");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
