package homework.finals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RequestManager {
    private Socket socket;
    private char[] buf = new char[512];

    public RequestManager(Socket socket) {
        this.socket = socket;
    }

    public RequestDto readRequest() {
        RequestDto requestDto = new RequestDto();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            reader.read(buf);
            String[] data = new String(buf).split("\n");
            Map<String, String> headerMap = new HashMap<>();
            String[] firstData = data[0].split(" ");
            headerMap.put("RequestMethod", firstData[0]);
            headerMap.put("Uri", firstData[1]);
            headerMap.put("HttpVersion", firstData[2]);

            for (String s : data) {
                String[] split = s.split(":");
                if (split.length >= 2) {
                    headerMap.put(split[0], split[1].trim());
                }
            }
            for (String s : headerMap.keySet()) {
                System.out.println(s + " : " + headerMap.get(s));
            }

            requestDto = new RequestDto();
            requestDto.setRequestMethod(headerMap.get("RequestMethod"));
            requestDto.setHttpVersion(headerMap.get("HttpVersion"));
            requestDto.setUri(headerMap.get("Uri"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestDto;

    }
}
