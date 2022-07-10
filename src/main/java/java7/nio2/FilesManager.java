package java7.nio2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilesManager {
    public static void main(String[] args) {

        FilesManager manager = new FilesManager();
        Path path = Paths.get("D:\\lgcns2021-1\\java8Example\\src\\main\\java\\java7\\nio2\\test.txt");
        try {
            Path writeData = manager.writeFile(path);
            manager.readFile(writeData);
            manager.copyMoveDelete(writeData, "test.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void copyMoveDelete(Path fromPath, String fileName) {
        Path parent = fromPath.toAbsolutePath().getParent();
        try {
            //test 라는 디렉터리 생성
            //"D:\\lgcns2021-1\\java8Example\\src\\main\\java\\java7\\nio2\\test"

            Path movePath = parent.resolve("move");
            System.out.println("movePath = " + movePath);
            Path copyPath = parent.resolve("copy");
            System.out.println("copyPath = " + copyPath);

            if (!Files.exists(movePath) || Files.exists(copyPath)) {
                Files.createDirectories(movePath);
                Files.createDirectories(copyPath);
            }
            //"D:\\lgcns2021-1\\java8Example\\src\\main\\java\\java7\\nio2\\test.txt\\test.txt"
            Path copy = parent.resolve(fileName);
            System.out.println(copy);
            StandardCopyOption soo = StandardCopyOption.REPLACE_EXISTING;
            Files.copy(copy, copyPath.resolve(fileName), soo);

            //5초후 nio/test.txt -> move/move.txt로 옮겨짐
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Files.move(copy, movePath.resolve("move.txt"), soo);


            //파일 및 디렉토리 삭제
            Files.delete(movePath.resolve("move.txt"));
            Files.delete(copyPath.resolve(fileName));
            Files.delete(movePath);
            Files.delete(copyPath);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Path writeFile(Path path) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        List<String> contents = getContents();
        StandardOpenOption openOption = StandardOpenOption.CREATE;
        return Files.write(path, contents, charset, openOption);
    }

    public List<String> getContents() {
        List<String> contents = new ArrayList<>();
        contents.add("첫째줄 리딩");
        contents.add("둘째줄 리딩");
        contents.add("세째줄 리딩");
        contents.add("넷째줄 리딩");
        contents.add("현재시간" + LocalDateTime.now());
        return contents;
    }

    public void readFile(Path path) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        List<String> strings = Files.readAllLines(path, charset);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
