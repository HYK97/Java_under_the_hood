package io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

public class FileMethod {
    public static void main(String[] args) {
        fileInfo("D:\\lgcns2021-1\\java8Example\\src\\main\\java\\io");
        fileInfo("D:\\lgcns2021-1\\java8Example\\src\\main\\java\\io\\FileDir.java");
        fileInfo("D:\\lgcns2021-1\\java8Example\\src\\main\\java\\io\\hidden.txt");
        fileRoots();
        FileFilter();


    }

    private static void fileInfo(String path) {
        File file = new File(path);
        System.out.println(file.getName() + " 얘는 디렉토리인가? " + file.isDirectory());
        System.out.println(file.getName() + " 얘는 파일인가?? " + file.isFile());
        System.out.println(file.getName() + " 얘는 숨김파일인가?? " + file.isHidden());
        System.out.println(file.getName() + " 생성일자 " + new Date(file.lastModified()));
        System.out.println(file.getName() + " 자신을 제외한경로 " + file.getParent());
        try {
            System.out.println(file.getName() + " 유일한 절대경로 " + file.getCanonicalPath());
            System.out.println(file.getName() + " 상대 절대경로 " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("========================================================================");
    }

    private static void fileRoots() {
        File[] files = File.listRoots();
        for (File file : files) {
            try {
                System.out.println("루트 위치= " + file.getCanonicalPath());
                String[] list = file.list();
                for (String s : list) {
                    System.out.println(file.getCanonicalPath() + " 디렉터리 하위 파일명 = " + s);
                }
                System.out.println("========================================================================");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void FileFilter() {
        File[] files = File.listRoots();
        for (File file : files) {
            try {
                System.out.println("루트 위치= " + file.getCanonicalPath());
                FilenameFilter filter = (dir, name) -> {
                    if (name.endsWith(".zip")) {
                        return true;
                    } else {
                        return false;
                    }
                };
                String[] list = file.list(filter);
                for (String s : list) {
                    System.out.println("필터걸친 파일들 " + s);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
