package socket.outinstream;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
        startClient("message1.\n");
        startClient("message2.\n");
        startClient("message3.\n");
        startClient("message4.\n");
        startClient("exit.\n");

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
//            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            //message 전송
            bw.write(data);
            bw.flush();

            Thread.sleep(1000);
            //server응답 메세지
            System.out.println(br.readLine());


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
