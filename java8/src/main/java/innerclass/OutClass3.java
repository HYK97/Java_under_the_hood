package innerclass;

public class OutClass3 {
    private String data;

    public void getData() {
        //이처럼 Wrapper Class에서도 내부 클래스의 변수에 접근이 가능하긴 하다
        //System.out.println("innerData = " + new nestedInnerClass().innerData);


    }

    class nestedInnerClass {
        private String innerData;

        public void printData() {
            System.out.println("data = " + data);
        }

    }
}
