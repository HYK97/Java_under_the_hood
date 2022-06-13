package inheritance;

public class Main {

    public static void main(String[] args) {

        Parent parent = new Parent();

        Parent child = new Child();

        Parent[] arrayParent = new Parent[7];
        for (int i = 0; i < arrayParent.length; i++) {
            if (i % 2 == 0) {
                arrayParent[i] = new Child();
            } else {
                arrayParent[i] = new Parent();
            }
        }
        /**
         * parent 를 먼저 비교할시
         *
         * 출력값 :
         * parentObject
         * parentObject
         * parentObject
         * parentObject
         * parentObject
         * 결론 -> parent객체로 instanceof 하면 하위의 객체들도 true로 반환 즉
         * instacneof는 비교는 무조건 하위객체에서 부터 실행하도록 한다.
         *
         * */
        for (Parent parent1 : arrayParent) {
            if (parent1 instanceof Parent) {
                System.out.println("parentObject");
            } else {
                System.out.println("childObject");
            }

        }
        /**
         * 개선버전
         * */
        System.out.println("\n====================\n");
        for (Parent parent1 : arrayParent) {
            if (parent1 instanceof Child) {
                System.out.println("childObject");
            } else {
                System.out.println("parentObject");
            }
        }
        Parent parent1 = new Parent();
        Parent parent2 =new ChildOther();
        Parent parent3 =new Child();

        parent1.printName();
        parent2.printName();
        parent3.printName();




    }
}
