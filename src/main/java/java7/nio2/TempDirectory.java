package java7.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TempDirectory {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\lgcns2021-1\\java8Example\\src\\main\\java\\java7\\nio2");
        try {
            Path temp = Files.createTempDirectory(path, "temp");
            Path tempFile = Files.createTempFile(path, "testFile", "txt");
            System.out.println("tempFile = " + tempFile);
            System.out.println(tempFile);
            //jvm 종료시 자동파일삭제
            new File(String.valueOf(temp)).deleteOnExit();
            new File(String.valueOf(tempFile)).deleteOnExit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
