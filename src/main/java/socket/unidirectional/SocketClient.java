package socket.unidirectional;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            socketClientStart(i + " : 번쨰 data");
        }
        socketClientStart("exit");
    }

    public static void socketClientStart(String data) {
        Socket sc = null;
        try {
            System.out.println("소켓 생성");
            sc = new Socket("127.0.0.1", 1234);
            Thread.sleep(1000);
            System.out.println("Client Connect Status " + sc.isConnected());
            OutputStream outputStream = sc.getOutputStream();
            OutputStreamWriter OutputStreamWriter = new OutputStreamWriter(outputStream);
            OutputStreamWriter.write(data);
            OutputStreamWriter.close();
            outputStream.close();

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
