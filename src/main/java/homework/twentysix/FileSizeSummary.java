package homework.twentysix;

import java.io.File;
import java.text.DecimalFormat;

public class FileSizeSummary {
    public static void main(String[] args) {
        FileSizeSummary fs = new FileSizeSummary();
        String path = "D:\\lgcns2021-1\\java8Example";
        long sum = fs.printFileSize(path);
        System.out.println(path + " total size" + fs.convertFileLength(sum));
    }

    private long printFileSize(String path) {
        File file = new File(path);
        long sum = 0;
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {

                sum += f.length();
                System.out.println(f.getName() + "  크기 : " + convertFileLength(f.length()));
            } else {
                String path2 = f.getAbsolutePath();
                long size = printFileSize(path2);
                sum += size;
                System.out.println(path2 + " 디렉터리 크기" + convertFileLength(size));
            }
        }
        return sum;
    }

    private String convertFileLength(long fileLength) {
        String result = "";
        DecimalFormat format = new DecimalFormat("#,##0.0#");
        if (fileLength <= 1024) {
            result = format.format(1.0 * fileLength) + "b";
        } else if (fileLength <= 1024 * 1024) {
            result = format.format(1.0 * fileLength / 1024) + "kb";
        } else if (fileLength <= 1024 * 1024 * 1024) {
            result = format.format(1.0 * fileLength / (1024 * 1024)) + "mb";
        } else if (fileLength <= 1024 * 1024 * 1024 * 1024) {
            result = format.format(1.0 * fileLength / (1024 * 1024 * 1024)) + "gb";
        }
        return result;
    }
}
