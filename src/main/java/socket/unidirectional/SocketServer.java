package socket.unidirectional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        startSocket();
    }

    private static void startSocket() {
        ServerSocket ss = null;
        Socket sc = null;
        try {
            ss = new ServerSocket(1234);
            while (true) {
                System.out.println("Waiting for client");
                sc = ss.accept();
                InputStream is = sc.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String data = null;
                StringBuilder receive = new StringBuilder();
                while ((data = br.readLine()) != null) {
                    receive.append(data);
                }
                System.out.println("받은데이터 = " + receive);
                br.close();
                is.close();
                if (receive != null && "exit".equals(receive.toString())) {
                    System.out.println("end socket server");
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
