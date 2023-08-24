package inheritance;

public class Main2 {

    /**
     * 생성자 순서에 대해서 overraide에 대해서
     */
    public static void main(String[] args) {

        Parent p = new Child();
        p.printName();
        p.printSex();


    }
}
