package effective_java.item2.builder.extendsbuilder;

public class Run {
    public static void main(String[] args) {
        Car myCar = new Car.Builder().addOption(Option.Bluetooth).addOption(Option.CdPlayer).color(Color.Blue).build();
        System.out.println("myCar = " + myCar);
        Bike myBike = new Bike.Builder("red").addHorn("부릉").addHorn("빵").addOption(Option.Bluetooth).build();
        System.out.println("myBike = " + myBike);
    }
}
