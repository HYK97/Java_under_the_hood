package effective_java.item2.finalizerandcleaner;

public class Run {
    public static void main(String[] args) {
        try (AutoCloseableTest au = new AutoCloseableTest()) {
            au.print("test 출력");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
