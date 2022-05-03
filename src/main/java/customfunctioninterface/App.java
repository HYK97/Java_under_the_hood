package customfunctioninterface;

import java.time.LocalDate;

public class App {

    private Print print;

    public App(Print print) {
        this.print = print;
    }

    public static void main(String[] args) {
        App app = new App(new Print());

        String s1 = app.print.stringPrinter("안녕", "하세", "요", (a, b, c) -> String.valueOf(a + b + c));
        String s2 = app.print.twoParametersPrinter("hello","hi",(a,b)-> String.valueOf(a+b));
        String s3 = app.print.nonGenericString("지금 시간 : ",(i)-> i+ LocalDate.now());

        /**
         * Functional InterFace의 AbstractMethod가 Generic Method 일 경우 Lambda Expression 사용이 불가능하다
         * 대신 메소드 참조는 사용가능하다
         * */
        //String s4e = app.print.<String>genericMethodString("k", (j)-> j.toString());

        //익명함수 사용가능
        String s4 = app.print.genericMethodString("익명함수", new GenericMethodFunctional() {
            @Override
            public <T> String start(T string) {
                return string.toString();
            }
        });
        //메소드 참조 사용가능
        String s5 = app.print.genericMethodString("method 참조", String::valueOf);
        Integer i = app.print.freePrinter("1","2","3",(a,b,c)-> Integer.valueOf(a)+Integer.valueOf(b)+Integer.valueOf(c));

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);
        System.out.println("s5 = " + s5);
        System.out.println("i = " + i);

    }

}
