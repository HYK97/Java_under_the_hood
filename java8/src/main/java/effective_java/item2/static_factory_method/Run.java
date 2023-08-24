package effective_java.item2.static_factory_method;

public class Run {
    public static void main(String[] args) {
        TestService getInstance1 = TestService.getInstance(10);
        TestService getInstance2 = TestService.getInstance(100);
        System.out.println(getInstance1.getClass());
        System.out.println(getInstance2.getClass());
        TestService getInstance3 = TestService.getInstance(100);
        System.out.println("getInstance2.hashCode() = " + getInstance2.hashCode());
        System.out.println("getInstance3.hashCode() = " + getInstance3.hashCode());
        System.out.println("getInstance2,getInstance3 equals = " + getInstance2.equals(getInstance3));


        TestService newInstance1 = TestService.newInstance(100);
        TestService newInstance2 = TestService.newInstance(100);
        System.out.println("newInstance1,newInstance2 equals = " + newInstance1.equals(newInstance2));
    }
}
