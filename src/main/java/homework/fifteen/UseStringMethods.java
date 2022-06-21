package homework.fifteen;

public class UseStringMethods {

    public static void main(String[] args) {
        String text = "The String class represents character strings";
        UseStringMethods use = new UseStringMethods();
        use.printWords(text);
        use.findString(text, "string");
        use.findAnyCaseString(text, "string");
        use.countChar(text, 's');
        use.printContainWords(text, "ss");
    }

    public void printWords(String str) {
        String[] split = str.split(" ");
        for (String s : split) {
            System.out.println(s);
        }

    }

    public void findString(String str, String findStr) {
        int i = str.indexOf(findStr);
        System.out.println(findStr + "은 " + i + "번째부터 시작합니다.");
    }

    public void findAnyCaseString(String str, String findStr) {
        int i = str.toLowerCase().indexOf(findStr);
        System.out.println(findStr + "은 " + i + "번째부터 시작합니다.");
    }

    public void countChar(String str, char c) {
        int count = 0;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar == c) {
                count++;
            }
        }
        System.out.println(c + " 는 총 " + count + "개 들어있습니다.");
    }

    public void printContainWords(String str, String findStar) {
        String[] split = str.split(" ");
        for (String s : split) {
            if (s.contains(findStar)) {
                System.out.println(s + " 는 " + findStar + " 포함 문장입니다");
            }
        }
    }

}
