package java7.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchExample extends Thread {

    String dirName;

    public WatchExample(String dirName) {
        this.dirName = dirName;
    }

    public static void main(String[] args) {
        String dirName = "D:\\lgcns2021-1\\java8Example\\src\\main\\java\\java7\\nio2";
        String fileName = "Watch.txt";
        WatchExample thread = new WatchExample(dirName);
        //이럴때 사용하는것이 DemonThread -> 모니터링
        thread.setDaemon(true);
        thread.start();
        try {
            thread.sleep(1000);
            for (int i = 0; i < 10; i++) {
                thread.fileWriteDelete(dirName, fileName + i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        System.out.println("### Watcher ###");
        System.out.println("DIR = " + dirName);
        addWatcher();
    }

    public void addWatcher() {
        try {
            Path dir = Paths.get(dirName);
            WatchService watchService = FileSystems.getDefault().newWatchService();
            WatchKey key = dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
            while (true) {
                key = watchService.take();
                List<WatchEvent<?>> watchEvents = key.pollEvents();
                for (WatchEvent<?> event : watchEvents) {
                    Path name = (Path) event.context();
                    if (event.kind() == ENTRY_CREATE) {
                        System.out.println(name + "create");
                    } else if (event.kind() == ENTRY_MODIFY) {
                        System.out.println(name + "modify");
                    } else if (event.kind() == ENTRY_DELETE) {
                        System.out.println(name + "delete");
                    }
                }
                key.reset();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileWriteDelete(String dirName, String fileName) {
        Path path = Paths.get(dirName, fileName);
        String contents = "test Sample";
        StandardOpenOption option = StandardOpenOption.CREATE;
        try {
            System.out.println("  파일생성 " + fileName);
            Files.write(path, contents.getBytes(), option);
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
