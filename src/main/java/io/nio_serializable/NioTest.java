package io.nio_serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    public static void main(String[] args) {
        String path = "D:\\lgcns2021-1\\java8Example\\src\\main\\java\\io\\nio_serializable\\test.txt";
        String data = "test data";
        writeFile(path, data);
        readFile(path);

    }

    private static void readFile(String path) {
        FileChannel fc = null;
        try {
            fc = new FileInputStream(path).getChannel();
            ByteBuffer bf = ByteBuffer.allocate(1000);
            fc.read(bf);
            bf.flip();
            while (bf.hasRemaining()) {
                System.out.print((char) bf.get());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String path, String data) {
        FileChannel fc = null;
        try {
            fc = new FileOutputStream(path).getChannel();
            byte[] bytes = data.getBytes();
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            fc.write(buf);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fc.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
