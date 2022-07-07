package socket.threadsocket;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        Socket socket = null;
        try {

            socket = new Socket("127.0.0.1", 1234);
            System.out.println("채팅시작");
            StartOutPutSocket out = new StartOutPutSocket(socket, "client");
            StartInputSocket in = new StartInputSocket(socket);
            in.start();
            out.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
