package java7.nio2;

import java.nio.file.*;

public class PathsAndFiles {
    public static void main(String[] args) {

        String path1 = "D:\\lgcns2021-1\\java8Example\\src\\main\\java\\java7";
        String path2 = "D:\\lgcns 2021-1학기\\springtool";
        PathsAndFiles run = new PathsAndFiles();
        run.checkPath(path1, path2);
        String uri1 = "www.google.com/test/main/files";

        run.paths(uri1);

        run.getFileSystems();

    }

    public void paths(String uri) {
        Path pathUri = Paths.get(uri);
        System.out.println("pathUri.getRoot() = " + pathUri.getRoot());
        System.out.println("pathUri.getParent() = " + pathUri.getParent());
        System.out.println("pathUri.getFileSystem() = " + pathUri.getFileSystem());
    }

    public void checkPath(String p1, String p2) {
        Path path1 = Paths.get(p1);
        Path path2 = Paths.get(p2);
        //path1 에서 path2 로이동할 상대경로 리턴
        Path relativize = path1.relativize(path2);
        System.out.println("relativize = " + relativize);
        //상대경로를 절대경로로 변경
        Path absolutePath = relativize.toAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
        //.. /./ 제거
        Path normalize = absolutePath.normalize();
        System.out.println("normalize = " + normalize);
        //path추가
        Path resolve = path1.resolve("java8Example");
        System.out.println("resolve = " + resolve);

    }

    public void getFileSystems() {
        FileSystem fileSystem = FileSystems.getDefault();
        Iterable<FileStore> fileStores = fileSystem.getFileStores();
        for (FileStore fileStore : fileStores) {
            System.out.println(fileStore.toString());
        }
        Iterable<Path> rootDirectories = fileSystem.getRootDirectories();
        for (Path rootDirectory : rootDirectories) {
            System.out.println("rootDirectory.toString() = " + rootDirectory.toString());
        }


    }
}
