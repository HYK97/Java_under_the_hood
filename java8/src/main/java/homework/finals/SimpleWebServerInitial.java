package homework.finals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServerInitial {
    static final String HEADER_CODE = "HTTP/1.1 200 OK";
    static final String HEADER_CONTENT_TYPE = "Content-Type: text/html; charset=UTF-8";

    static final char[] BUF = new char[1024];

    public static void main(String[] args) {
        startServer("hello", 9000);
    }

    private static void startServer(String content, int port) {
        ServerSocket server = null;
        try {
            while (true) {
                server = new ServerSocket(port);
                Socket accept = server.accept();
                System.out.println("===========요청==============");
                BufferedReader request = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                request.read(BUF);
                String[] data = new String(BUF).split("\n");
                for (String datum : data) {
                    System.out.println(datum);
                    System.out.println("===");
                }
                System.out.println("===========응답==============");
                PrintWriter response = new PrintWriter(accept.getOutputStream());
                response.println(HEADER_CODE);
                response.println(HEADER_CONTENT_TYPE);
                response.println();
                response.print(content);
                response.flush();
                accept.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
