package effective_java.item2.builder;

public class Car {
    private final String color;
    private final String carName;
    private final int wheelCount;

    /*생성자는 private로 선언*/
    private Car(Builder builder) {
        this.color = builder.color;
        this.carName = builder.carName;
        this.wheelCount = builder.wheelCount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", carName='" + carName + '\'' +
                ", wheelCount=" + wheelCount +
                '}';
    }

    static class Builder {
        //필수 매개 변수
        private final String color;
        //선택적 매개 변수
        private String carName = "붕붕이";
        private int wheelCount = 4;

        public Builder(String color) {
            this.color = color;
        }

        public Builder carName(String carName) {
            this.carName = carName;
            return this;
        }

        public Builder wheelCount(int wheelCount) {
            this.wheelCount = wheelCount;
            return this;
        }

        /**
         * 바깥에서는 Builder를 통해서 Car를 생성할수있도록 public 생성자를 만들어둠
         * 마지막에 선언되므로써 각 필드의 값을 저장된 Car 객체를 반환하게함
         */
        public Car build() {
            return new Car(this);
        }
    }
}
