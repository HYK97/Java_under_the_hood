package homework.seventeen;

public class MyPage {
    static InputBox input;

    public static void main(String[] args) {
        setUI();
        pressKey(2);
        pressKey(4);
    }

    public static void pressKey(int eventType) {
        input.listenerCalled(eventType);
    }

    public static void setUI() {
        input = new InputBox();
        input.setListener(new KeyEventListener() {
            @Override
            public void onKeyDown() {
                System.out.println(" KEYDOWN ");
            }

            @Override
            public void onkeyUp() {
                System.out.println(" KEYUP ");
            }
        });
    }
}
