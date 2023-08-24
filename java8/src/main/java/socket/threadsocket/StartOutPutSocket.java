package socket.threadsocket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StartOutPutSocket extends Thread {
    private Socket socket;
    private String username;


    public StartOutPutSocket(Socket socket, String username) {
        this.socket = socket;
        this.username = username;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                OutputStream out = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println(username + " : " + scanner.nextLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
