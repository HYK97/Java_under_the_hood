import org.junit.jupiter.api.Test;

public class TestCod {
    int count = 0;

    public void plus() {
        //인적사항
        System.out.println("tttttttttttt");
        System.out.println("tttttttttttt");
        System.out.println("tttttttttttt");
        System.out.println("tttttttttttt");
        System.out.println("tttttttttttt");
        System.out.println("tttttttttttt");
        System.out.println("tttttttttttt");
        synchronized (this) {
            count++;
        }
    }


    @Test
    public void test() throws InterruptedException {
        TestCod a = new TestCod();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(a::plus);
            thread.start();
            thread.join();
        }

        System.out.println(a.count);
    }
}
