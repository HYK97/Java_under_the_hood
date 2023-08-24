package io;

import java.io.*;
import java.util.Scanner;

public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\lgcns2021-1\\java8Example\\src\\main\\java\\io\\fileWrite.txt";
        File file = new File(filePath);
        file.createNewFile();

        //writeFile(file, 10);
        //readFile(file);
        readScannerFile(file);


    }

    private static void writeFile(File file, int count) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);// true 덮어쓰기
            bw = new BufferedWriter(fw);
            for (int i = 0; i < count; i++) {
                bw.write(String.valueOf(i));
                bw.newLine();
                //flush하면 하나씩 바로바로 써지는걸확인가능함
                //bw.flush();
                //Thread.sleep(2000);
            }
            System.out.println("완료");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } /*catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/ finally {
            close(bw, fw, null, null);
        }
    }

    private static void readFile(File file) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(file);// true 덮어쓰기
            br = new BufferedReader(fr);
            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close(null, null, br, fr);
        }
    }

    private static void readScannerFile(File file) {
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.print(sc.nextLine() + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            sc.close();
        }
    }


    private static void close(BufferedWriter bw, FileWriter fw, BufferedReader br, FileReader fr) {
        if (bw != null) {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if (fw != null) {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if (fr != null) {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
