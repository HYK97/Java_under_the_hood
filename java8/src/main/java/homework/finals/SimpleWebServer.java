package homework.finals;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {
    public static void main(String[] args) {
        SimpleWebServer server = new SimpleWebServer();
        server.run();
    }

    public void run() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(9000);
            while (true) {
                Socket socket = server.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
