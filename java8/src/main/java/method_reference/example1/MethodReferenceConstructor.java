package method_reference.example1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Set;
import java.util.function.Function;

public class MethodReferenceConstructor {
    public static void main(String[] args) {
        /**
         * 생성자를 MethodReference를 이용해 사용하는방법
         * */


        final Section section =new Section(1);
        //Lambda 이용
        final Function<Integer, Section> sectionFactoryWithLambda = number -> new Section(number);
        final Section sectionWithLambda = sectionFactoryWithLambda.apply(1);
        System.out.println("section = " + section);
        System.out.println("sectionWithLambda = " + sectionWithLambda);

        //Method Reference 이용
        final Function<Integer, Section> sectionFactoryWithMethodReference = Section::new;
        Section sectionMethodReference = sectionFactoryWithMethodReference.apply(1);
        System.out.println("sectionMethodReference = " + sectionMethodReference);

        //매개변수 3개이상
        final OldProduct product = new OldProduct(1L , "A", new BigDecimal("100"));
        System.out.println("oldProduct = " + product);
        final OldProductFactory oldProductFactory =OldProduct::new;
        System.out.println("oldProductFactory = "+oldProductFactory.create(1L,"A",new BigDecimal("100")));



        //사용 예시
        ProductA productA = createProduct(1L, "A", new BigDecimal("100"), ProductA::new);
        ProductB productB = createProduct(2L, "B", new BigDecimal("200"), ProductB::new);
        System.out.println("productA = " + productA);
        System.out.println("productB = " + productB);

    }

    private static <T extends Product> T createProduct(final Long id,
                                                       final String name,
                                                       final BigDecimal price,
                                                       final ProductCreator<T> productCreator) {
        if (id == null || id < 1L) {
            throw new IllegalArgumentException("잘못된 id");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("잘못된 이름");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) { // price <= ZERO
            throw new IllegalArgumentException("잘못된 가격");
        }
        return productCreator.create(id, name, price);
    }

}


interface OldProductFactory {
    OldProduct create(Long id, String name,BigDecimal price);
}
@FunctionalInterface
interface ProductCreator<T extends Product> {
    T create(Long id, String name, BigDecimal price);
}


@AllArgsConstructor
@Data
class Section{
    private int number;
}
@Data
@AllArgsConstructor
class  OldProduct{
    private Long id;
    private String name;
    private BigDecimal price;


}
class ProductA extends Product {

    public ProductA(final Long id, final String name, final BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "A=" + super.toString();
    }
}

class ProductB extends Product {

    public ProductB(final Long id, final String name, final BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "B=" + super.toString();
    }
}
@AllArgsConstructor
@Data
abstract class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

