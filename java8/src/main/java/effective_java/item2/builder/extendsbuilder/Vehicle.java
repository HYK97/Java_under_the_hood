package effective_java.item2.builder.extendsbuilder;

import lombok.ToString;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

@ToString
public class Vehicle {
    private final Set<Option> options;

    public Vehicle(Builder<?> builder) {
        this.options = builder.options.clone();
    }

    abstract static class Builder<T extends Builder<T>> {
        private EnumSet<Option> options = EnumSet.noneOf(Option.class);

        public T addOption(Option option) {
            options.add(Objects.requireNonNull(option));
            return self();
        }

        abstract Vehicle build();

        protected abstract T self();
    }
}
