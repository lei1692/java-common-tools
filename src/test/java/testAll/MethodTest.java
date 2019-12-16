package testAll;

import org.junit.Test;

public class MethodTest {
    @Test
    public void 字符串堆和常量池的测试() {
//        两个都是在常量池中，两个变量指向常量池中的同一个字符串
        String str = "hello ";
        String str1 = "hello ";
        System.out.println("str == str1: "+(str == str1));

//        两个引号的字符串相加==直接用引号进行赋值，都是在常量池中
        String str11 = "hello world";
        String str13 = "hello " + "world";
        System.out.println("str11 == str13: "+(str11 == str13));

//        字符串变量+引号字符串是在堆中的，
//        在堆中的字符串都是不一样的，因为每一次的创建堆中的都是不同的空间
        String str12 = "world";
        String str14 = new String("hello world");
        String str16 = new String("hello world");
        System.out.println("str14==str16: "+(str14==str16));
        String str15 = str + "world";
        System.out.println("str15 == str14: "+(str15 == str14));
        System.out.println("str15 == str11: "+(str15 == str11));

//        使用inturn()方法来讲原本应该在堆中创建的现在转到常量池中去创建
//        str2使用inturn()方法之后，再对str2进行赋值，还是在常量池中去寻找
        String str2 = new String("hello world").intern();
        System.out.println("str11 == str2: "+(str11 == str2));
        str2 = "hello ";
        System.out.println("str1 == str2: "+(str1 ==str2));
        String str21 = new String().intern();
        str21 = "world";
        System.out.println("str21 == str12: "+(str21 ==str12));
        String str22 = str15.intern();
        System.out.println("str22 ==str11:  "+(str22 == str11));



    }
}
