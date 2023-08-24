package socket.threadsocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket sc = null;
        Socket socket = null;
        try {
            sc = new ServerSocket(1234);
            socket = sc.accept();
            System.out.println("채팅시작");
            StartOutPutSocket out = new StartOutPutSocket(socket, "server");
            StartInputSocket in = new StartInputSocket(socket);
            in.start();
            out.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
