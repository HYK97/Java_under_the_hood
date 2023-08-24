package socket.bidirectional;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
        startClient("message1.");
        startClient("message2.");
        startClient("message3.");
        startClient("message4.");
        startClient("exit.");

    }

    public static void startClient(String data) {

        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 1234); // 소켓 서버에 접속
            System.out.println("서버에 접속 성공!");

            //입출력 Stream return
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            //체이닝
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            //message 전송
            pw.println(data);

            //server응답 메세지
            System.out.println(br.readLine());


            pw.close();
            br.close();
            out.close();
            in.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
