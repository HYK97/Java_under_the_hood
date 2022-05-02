package customfunctioninterface;

@FunctionalInterface
public interface GenericMethodFunctional {
    <T> String start(T string);
}
