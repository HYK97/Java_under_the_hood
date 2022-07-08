package homework.finals;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class ResponseManager {
    static final String HEADER_CODE = "HTTP/1.1 200 OK";
    static final String HEADER_CONTENT_TYPE = "Content-Type: text/html; charset=UTF-8";
    private Socket socket;
    private RequestDto requestDto;

    public ResponseManager(Socket socket, RequestDto requestDto) {
        this.socket = socket;
        this.requestDto = requestDto;
    }

    public void writeResponse() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(requestDto);
        if (requestDto.getUri().equals("/today")) {
            writer.println(HEADER_CODE);
            writer.println(HEADER_CONTENT_TYPE);
            writer.println();
            writer.print("<h2>" + LocalDateTime.now() + "</h2>");
        } else if (requestDto.getUri().equals("/welcome")) {
            writer.println(HEADER_CODE);
            writer.println(HEADER_CONTENT_TYPE);
            writer.println();
            writer.print("<h2>환영합니다</h2>");
        } else {
            writer.println(HEADER_CODE);
            writer.println(HEADER_CONTENT_TYPE);
            writer.println();
            writer.print("<h2>메인페이지</h2>");
        }
        writer.flush();


    }
}
