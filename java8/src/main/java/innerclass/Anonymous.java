package innerclass;

@FunctionalInterface
public interface Anonymous<T> {
    T run(T... Param);
}
