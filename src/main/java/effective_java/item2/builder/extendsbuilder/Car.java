package effective_java.item2.builder.extendsbuilder;

import lombok.ToString;

@ToString(callSuper = true)
public class Car extends Vehicle {
    private final Color color;

    public Car(Builder builder) {
        super(builder);
        this.color = builder.color;
    }

    public static class Builder extends Vehicle.Builder<Builder> {
        private Color color;

        public Builder color(Color color) {
            this.color = color;
            return this;
        }


        @Override
        public Car build() {
            return new Car(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }


}
