package block;

public class BlockTest {
    static {
        System.out.println(" 스태틱블록");
    }

    {
        System.out.println(" 난 인스턴스 블록");
    }


    public BlockTest() {
        System.out.println(" 생성자 호출 ");

    }

    public static void main(String[] args) {
        BlockTest one = new BlockTest();
        BlockTest two = new BlockTest();
    }
}
