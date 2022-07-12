package effective_java.item2.builder.extendsbuilder;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
public class Bike extends Vehicle {
    private final List<String> customHorn;
    private final String color;

    public Bike(Builder builder) {
        super(builder);
        this.customHorn = new ArrayList<>(builder.customHorn);
        this.color = builder.color;
    }

    public static class Builder extends Vehicle.Builder<Builder> {
        private final List<String> customHorn = new ArrayList<>();
        private final String color;

        public Builder(String color) {
            this.color = color;
        }

        public Builder addHorn(String horn) {
            customHorn.add(horn);
            return this;
        }

        @Override
        Bike build() {
            return new Bike(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
