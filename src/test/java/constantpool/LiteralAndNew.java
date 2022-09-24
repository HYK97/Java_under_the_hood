package constantpool;

import org.junit.jupiter.api.Test;

public class LiteralAndNew {
    @Test
    public void test() {
        //바이트코드
        /**
         * Classfile /Users/hyunyoungkim/Desktop/myGit/JAVA8Notes/out/test/classes/constantpool/LiteralAndNew.class
         *   Last modified 2022. 9. 24.; size 795 bytes
         *   MD5 checksum f686775f8a42f9972b59840dec752e59
         *   Compiled from "LiteralAndNew.java"
         * public class constantpool.LiteralAndNew
         *   minor version: 0
         *   major version: 52
         *   flags: (0x0021) ACC_PUBLIC, ACC_SUPER
         *   this_class: #9                          // constantpool/LiteralAndNew
         *   super_class: #10                        // java/lang/Object
         *   interfaces: 0, fields: 0, methods: 2, attributes: 1
         * Constant pool:
         *    #1 = Methodref          #10.#31        // java/lang/Object."<init>":()V
         *    #2 = String             #19            // data1
         *    #3 = Class              #32            // java/lang/String
         *    #4 = String             #21            // data2
         *    #5 = Methodref          #3.#33         // java/lang/String."<init>":(Ljava/lang/String;)V
         *    #6 = Methodref          #7.#34         // java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
         *    #7 = Class              #35            // java/lang/Integer
         *    #8 = Methodref          #7.#36         // java/lang/Integer."<init>":(I)V
         *    #9 = Class              #37            // constantpool/LiteralAndNew
         *   #10 = Class              #38            // java/lang/Object
         *   #11 = Utf8               <init>
         *   #12 = Utf8               ()V
         *   #13 = Utf8               Code
         *   #14 = Utf8               LineNumberTable
         *   #15 = Utf8               LocalVariableTable
         *   #16 = Utf8               this
         *   #17 = Utf8               Lconstantpool/LiteralAndNew;
         *   #18 = Utf8               test
         *   #19 = Utf8               data1
         *   #20 = Utf8               Ljava/lang/String;
         *   #21 = Utf8               data2
         *   #22 = Utf8               data3
         *   #23 = Utf8               Ljava/lang/Integer;
         *   #24 = Utf8               data4
         *   #25 = Utf8               data5
         *   #26 = Utf8               data6
         *   #27 = Utf8               RuntimeVisibleAnnotations
         *   #28 = Utf8               Lorg/junit/jupiter/api/Test;
         *   #29 = Utf8               SourceFile
         *   #30 = Utf8               LiteralAndNew.java
         *   #31 = NameAndType        #11:#12        // "<init>":()V
         *   #32 = Utf8               java/lang/String
         *   #33 = NameAndType        #11:#39        // "<init>":(Ljava/lang/String;)V
         *   #34 = NameAndType        #40:#41        // valueOf:(I)Ljava/lang/Integer;
         *   #35 = Utf8               java/lang/Integer
         *   #36 = NameAndType        #11:#42        // "<init>":(I)V
         *   #37 = Utf8               constantpool/LiteralAndNew
         *   #38 = Utf8               java/lang/Object
         *   #39 = Utf8               (Ljava/lang/String;)V
         *   #40 = Utf8               valueOf
         *   #41 = Utf8               (I)Ljava/lang/Integer;
         *   #42 = Utf8               (I)V
         * {
         *   public constantpool.LiteralAndNew();
         *     descriptor: ()V
         *     flags: (0x0001) ACC_PUBLIC
         *     Code:
         *       stack=1, locals=1, args_size=1
         *          0: aload_0
         *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         *          4: return
         *       LineNumberTable:
         *         line 5: 0
         *       LocalVariableTable:
         *         Start  Length  Slot  Name   Signature
         *             0       5     0  this   Lconstantpool/LiteralAndNew;
         *
         *   public void test();
         *     descriptor: ()V
         *     flags: (0x0001) ACC_PUBLIC
         *     Code:
         *       stack=3, locals=7, args_size=1
         *
         *          // 리터럴
         *          0: ldc           #2                  // String data1
         *          2: astore_1
         *
         *          //new
         *          3: new           #3                  // class java/lang/String
         *          6: dup
         *          7: ldc           #4                  // String data2
         *          9: invokespecial #5                  // Method java/lang/String."<init>":(Ljava/lang/String;)V
         *          12: astore_2
         *
         *          //리터럴
         *         13: iconst_1
         *         14: invokestatic  #6                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
         *         17: astore_3
         *
         *          //new
         *         18: new           #7                  // class java/lang/Integer
         *         21: dup
         *         22: iconst_2
         *         23: invokespecial #8                  // Method java/lang/Integer."<init>":(I)V
         *         26: astore        4
         *
         *
         *         //리터럴
         *         28: sipush        1000
         *         31: invokestatic  #6                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
         *         34: astore        5
         *
         *
         *          //new
         *         36: new           #7                  // class java/lang/Integer
         *         39: dup
         *         40: sipush        1002
         *         43: invokespecial #8                  // Method java/lang/Integer."<init>":(I)V
         *         46: astore        6
         *
         *
         *         48: return
         *
         *
         *       LineNumberTable:
         *         line 8: 0
         *         line 9: 3
         *         line 10: 13
         *         line 11: 18
         *         line 12: 28
         *         line 13: 36
         *         line 14: 48
         *       LocalVariableTable:
         *         Start  Length  Slot  Name   Signature
         *             0      49     0  this   Lconstantpool/LiteralAndNew;
         *             3      46     1 data1   Ljava/lang/String;
         *            13      36     2 data2   Ljava/lang/String;
         *            18      31     3 data3   Ljava/lang/Integer;
         *            28      21     4 data4   Ljava/lang/Integer;
         *            36      13     5 data5   Ljava/lang/Integer;
         *            48       1     6 data6   Ljava/lang/Integer;
         *     RuntimeVisibleAnnotations:
         *       0: #28()
         *         org.junit.jupiter.api.Test
         * }
         * SourceFile: "LiteralAndNew.java"
         *
         *
         * */

        String data1 = "data1";
        String data2 = new String("data2");
        Integer data3 = 1;
        Integer data4 = new Integer(2);
        Integer data5 = 1000;
        Integer data6 = new Integer(1002);

    }
}
