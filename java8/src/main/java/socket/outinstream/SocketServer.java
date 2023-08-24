package socket.outinstream;

import java.io.*;
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
                //대기

                sc = ss.accept();
                //입출력 Stream return
                Thread.sleep(1000);
                InputStream in = sc.getInputStream();
                OutputStream out = sc.getOutputStream();

                //체이닝
//                PrintWriter pw = new PrintWriter(new OutputStreamWriter(out), true);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                System.out.println("성공");
                //client에서 보낸 데이터 출력
                String message = null;

                while (br.ready()) { // readLine은 개행을 기준으로 사용된다. 중요!!!
                    message = br.readLine();
                }
                System.out.println("전송받은 데이터 : " + message);
                //client에 다시 return
                bw.write(message + ":  return");
                bw.flush();


                bw.close();
                br.close();
                out.close();
                in.close();
                sc.close();
                if (message != null && "exit".equals(message)) {
                    System.out.println("서버종료");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
