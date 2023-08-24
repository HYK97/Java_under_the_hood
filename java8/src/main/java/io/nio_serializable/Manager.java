package io.nio_serializable;

import java.io.*;
import java.math.BigDecimal;

public class Manager {
    public static void main(String[] args) throws IOException {

        String filePath = "D:\\lgcns2021-1\\java8Example\\src\\main\\java\\io\\nio_serializable\\Object.obj";
        SerialDto dto = new SerialDto("유저 1", "유저 아이디1", new BigDecimal(22222), "address");
        saveDto(dto, filePath);
        SerialDto readDto = readDto(filePath);
        System.out.println(readDto);
    }

    private static SerialDto readDto(String filePath) {
        FileInputStream fs = null;
        ObjectInputStream os = null;
        SerialDto result = null;
        try {
            fs = new FileInputStream(filePath);
            os = new ObjectInputStream(fs);
            result = (SerialDto) os.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return result;
    }

    private static void saveDto(SerialDto dto, String filePath) {
        ObjectOutputStream os = null;
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(filePath);
            os = new ObjectOutputStream(fs);
            os.writeObject(dto);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
