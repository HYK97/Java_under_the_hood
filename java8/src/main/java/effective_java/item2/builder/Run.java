package effective_java.item2.builder;

public class Run {
    public static void main(String[] args) {
        Car myCar = new Car.Builder("빨간색 (필수값)").carName("방방이").wheelCount(5).build();
        System.out.println("myCar = " + myCar);
        Car mySecondCar = new Car.Builder("파란색").build(); //기본값
        System.out.println("mySecondCar = " + mySecondCar);
    }
}
