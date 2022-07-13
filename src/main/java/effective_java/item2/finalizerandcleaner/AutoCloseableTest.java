package effective_java.item2.finalizerandcleaner;

public class AutoCloseableTest implements AutoCloseable {

    public void print(String test) {
        System.out.println("test = " + test);
    }


    @Override
    public void close() throws Exception {
        System.out.println("객체 close test");
    }
}
