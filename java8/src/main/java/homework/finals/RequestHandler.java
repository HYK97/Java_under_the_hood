package homework.finals;

import java.io.IOException;
import java.net.Socket;

public class RequestHandler extends Thread {
    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        RequestManager request = new RequestManager(socket);
        RequestDto requestDto = request.readRequest();
        ResponseManager response = new ResponseManager(socket, requestDto);
        response.writeResponse();
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
