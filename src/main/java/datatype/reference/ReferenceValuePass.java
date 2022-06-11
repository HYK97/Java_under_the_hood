package datatype.reference;

public class ReferenceValuePass {

    public static void main(String[] args) {
        ReferenceValuePass rv =new ReferenceValuePass();
        Member member =new Member("t1");

        rv.passByReference1(member);
        System.out.println("member = " + member.getUsername());


        rv.passByReference2(member);
        System.out.println("member = " + member.getUsername());

    }

    /**
     * refernce로 인한 원본데이터 변경됨
     * */
    public void passByReference1(Member member){
        member.setUsername("t2");
    }
    /**
     * string 객체도  String a ="b" -> 는 결국 String a =new String("b"); 와
     * 같기때문에 원본데이터가 바뀌지않음
     * */
    public void passByReference2(Member member){
        member=new Member("t3");
    }

    static class Member{

        public Member(String username) {
            this.username = username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        private String username;
    }
}
