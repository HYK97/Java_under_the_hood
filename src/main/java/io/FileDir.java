package io;

import java.io.File;

public class FileDir {
    public static void main(String[] args) {
        mkdirs();
        mkdir();
    }

    /**
     * 하위디렉터리까지만듬 true
     */
    private static void mkdirs() {
        String path = "C:" + File.separator + "mkdirs" + File.separator + "exam";
        File file = new File(path);
        boolean mkdirs = file.mkdirs();
        System.out.println("mkdirs = " + mkdirs);
        System.out.println("파일 삭제 = " + file.delete());

    }

    /**
     * 하위디렉터리는 만들지못하기때문에 false 즉 mkdir 까지만 생성되고 exam은 생성할수없기때문에 실패
     */
    private static void mkdir() {
        String path = "C:" + File.separator + "mkdir" + File.separator + "exam";
        File file = new File(path);
        boolean mkdir = file.mkdir();
        System.out.println("mkdir = " + mkdir);
        System.out.println("파일 삭제 = " + file.delete());// 생성된게없으므로 삭제도 안됌.
    }
}
