package string_operator;

import org.junit.jupiter.api.Test;

/**
 * L1
 * LINENUMBER 10 L1
 * LDC "k"
 * ASTORE 2
 * L2
 * LINENUMBER 11 L2
 * LDC "b"
 * ASTORE 3
 * L3
 * LINENUMBER 12 L3
 * NEW java/lang/StringBuilder
 * DUP
 * INVOKESPECIAL java/lang/StringBuilder.<init> ()V
 * ALOAD 2
 * INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 * ALOAD 3
 * INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 * INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
 * ASTORE 4
 * L4
 * LINENUMBER 13 L4
 * ALOAD 1
 * ALOAD 2
 * INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 * ALOAD 3
 * INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 * INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
 * ASTORE 5
 * L5
 * LINENUMBER 14 L5
 * GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
 * NEW java/lang/StringBuilder
 * DUP
 * INVOKESPECIAL java/lang/StringBuilder.<init> ()V
 * LDC "c = "    //ㄴㅐ부적으로 stringbuilder를 사용해서 최적화함
 * INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 * ALOAD 4
 * INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 * INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
 * INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
 * L6
 * LINENUMBER 15 L6
 * GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
 * NEW java/lang/StringBuilder
 * DUP
 * INVOKESPECIAL java/lang/StringBuilder.<init> ()V
 * LDC "d = "
 * INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 * ALOAD 5
 * INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 * INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
 * INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
 */
public class StringOperator {
    @Test
    public void string_operator() {
        StringBuilder stringBuilder = new StringBuilder();
        String a = "k";
        String b = "b";
        String c = a + b;
        String d = stringBuilder.append(a).append(b).toString();
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}
