package increment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;





public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Сервер ожидает запуск клиента...");

        try (Socket clientSocket = serverSocket.accept();
             InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {



            System.out.println("Подключилось новое устройство:" +
                    clientSocket.getInetAddress().toString() + ":" + clientSocket.getPort()) ;

            int sms;


            while ((sms = inputStream.read()) != -1) {
                System.out.println("Клиент прислал: " + sms);
                outputStream.write(++sms);
                outputStream.flush();
                System.out.println("Отправлено клиенту: " + sms);
            }
            System.out.println("Устройство отключено");
        }
    }
}
