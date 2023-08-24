package homework.twentyeight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            sendAndReceiveSocketData(i + " : 번쨰 data");
        }
        sendAndReceiveSocketData("exit");
    }

    public static void sendAndReceiveSocketData(String data) {
        Socket sc = null;
        try {
            System.out.println("소켓 생성");
            sc = new Socket("127.0.0.1", 1234);
            Thread.sleep(1000);
            System.out.println("Client Connect Status " + sc.isConnected());
            InputStream inputStream = sc.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(reader.readLine());

            reader.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                sc.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
