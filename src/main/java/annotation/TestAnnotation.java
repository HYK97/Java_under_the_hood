package annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    public int number();

    public String text() default " 기본데이터 ";


}
