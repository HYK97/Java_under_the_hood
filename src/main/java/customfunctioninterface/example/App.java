package customfunctioninterface.example;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {

    public static void main(String[] args) {

        Utils util = new Utils();
        final Product movie1= new Movie(1L,new BigDecimal("3000"),"김지훈","신과함께");
        final Product movie2= new Movie(2L,new BigDecimal("5000"),"지석진","바람과함께 사라지다");
        final Product movie3= new Movie(3L,new BigDecimal("4000"),"박성호","앵커");
        final Product food1= new Food(5L,new BigDecimal("1000"),"치토스맛 팝콘");
        final Product food2= new Food(6L,new BigDecimal("400"),"치즈맛 팝콘");
        final Product food3= new Food(7L,new BigDecimal("6000"),"핫도그");

        final Order order1 = new Order(1L,movie1,1);
        final Order order2 = new Order(2L,movie2,2);
        final Order order3 = new Order(3L,food1,4);
        final Order order4 = new Order(4L,food2,2);
        final Order order5 = new Order(5L,movie3,1);
        final Order order6 = new Order(6L,food3,2);

        final OrderList orderList1 =new OrderList(1L, Arrays.asList(order1,order2));
        final OrderList orderList2 =new OrderList(2L, Arrays.asList(order1,order2,order3,order4));
        final OrderList orderList3 =new OrderList(3L, Arrays.asList(order1,order2,order5,order6));
        final OrderList orderList4 =new OrderList(4L, Arrays.asList(order4));

        System.out.println("orderList1.getPrice() = " + orderList1.getPrice());
        System.out.println("orderList1.getPrice() = " + orderList2.getPrice());
        System.out.println("orderList1.getPrice() = " + orderList3.getPrice());
        System.out.println("orderList1.getPrice() = " + orderList4.getPrice());

        //4000원 이상의 주문만 받음
        final Predicate<Order> filter =(order)-> order.getPrice().compareTo(new BigDecimal("4000"))>=0;
        List<Order> resultOrderList = util.filter(orderList1.getOrderList(), filter);

        for (Order order : resultOrderList) {
            System.out.println("4000원 이상 주문 = " + order.toString());
        }

        //영화 중에 4000원 이상 필터
        final Predicate<Product> filter2 =(product) -> product.getPrice().compareTo(new BigDecimal("4000")  )>=0 && product.getClass().equals(Movie.class);

        //할인 영화 리스트 객체 형변환 필터
        final Function<Movie,DiscountMovie> filter3 = (movie)-> new DiscountMovie(movie.getId(),movie.getPrice().divide(new BigDecimal("2")), movie.getAuthor(), movie.getMovieName()) ;

        //4000원 이상 영화상품 리스트
        List<Product> ProductList = util.filter(util.mapper(orderList3.getOrderList(),(i)-> i.getProduct()), filter2);


        //Product -> Movie 형변환
        List<Movie> MovieList = util.mapper(ProductList,(i)-> (Movie)i);

        for (Product product : MovieList) {
            System.out.println("product = " + product.toString());
        }

        //Movie -> DiscountMovie 형변환
        List<DiscountMovie> DiscountMovie = util.mapper(MovieList,filter3);


        for (customfunctioninterface.example.DiscountMovie discountMovie : DiscountMovie) {
            System.out.println("discountMovie = " + discountMovie.toString());
        }



    }
}
