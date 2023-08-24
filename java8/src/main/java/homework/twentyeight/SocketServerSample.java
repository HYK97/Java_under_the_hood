package homework.twentyeight;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerSample {
    public static void main(String[] args) throws IOException {
        startReplyServer();
    }

    private static void startReplyServer() {
        ServerSocket ss = null;
        Socket sc = null;
        try {
            ss = new ServerSocket(1234);
            while (true) {
                System.out.println("Waiting for client");
                sc = ss.accept();

                OutputStream outputStream = sc.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
                bw.write(" ok ");
                bw.close();
                outputStream.close();

                bw.close();
                outputStream.close();

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

