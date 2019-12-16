package string;

import org.junit.Test;

public class StringTest {
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

    @Test
    public void 字符串长度的测试() {
//        使用length（）方法的结果是String类底层的字符数组的长度
//        但是有的时候一个字符长度不表示一个字符，有可能是两个或者多个字符长度来表示
//        一个字符，所以可以有
        String str = "ahello,\uD835\uDD5D\uD835\uDD60\uD835\uDD60\uD835\uDD5C";
        System.out.println(str);
        System.out.println("字符串的数组的长度： "+str.length());
        System.out.println("代码点数（表示实际的字符串的长度）："+str.codePointCount(0,str.length()));
        System.out.println("字符串里的字符数组在某个下标中字符的ascll码值："+str.codePointAt(0));
    }

    @Test
    public void 字符串子串substring方法截取() {
//        substring()方法有两种用法
//        1、只有一个参数，是从这个下标开始，一直取到最后一位
//        2、有两个参数,是下标开始，和下标结束，不包括下标结束的字符
//        也可以理解为，从开始下标开始，取长度为结束下标-开始下标
        String str = "hello,world";
        String str1 = str.substring(4);
        System.out.println(str1);
        String str2 = str.substring(4,str.length());
        System.out.println(str2);
        String str3 = str.substring(4,8);
        System.out.println(str3);
    }

    @Test
    public void 字符串的拼接Merge() {
        //字符串的拼接可以用+和+=两种，但是用的时候要注意是在堆中还是在常量池中

        String str = "hello ";
        String str1 = "world";
        String str11 = "hello " + "world";
        String str2 = "hello world";
        System.out.println(str2 == str11);

        str += "world";
        System.out.println("str == str2: "+ (str.intern() == str2));

    }

    @Test
    public void 字符串的格式化操作() {
//        不适用格式化的话，想要输出不同的数据类型，就需要很长的相加，不简洁
//        强制转化使用一个（）就可以了，括号里写需要转换的类型
        String str = "大写字母L:"+" L"+ " " + " \n";
        System.out.println(str);
        String str1 = String.format("大写字母L：%c \n",'L');
        System.out.println(str1);
        String str2 = String.format("大写字母L是：%c,\nL的ASCLL码值是：%d,\n输出一个数字是：%d，\n输出一个小数是%.2f\n",'L',(int)'L',4,1.23);
        System.out.println(str2);
    }

    @Test
    public void 字符串的匹配() {
//        判断两个字符串是否相等使用equals（）方法
//        如果不想区分大小写对的话使用equalsIgnoreCase（）方法

        String str = "hello";
        String str1 = "hello";
        String str2 = "HELLO";
        System.out.println(str.equals(str1));
        System.out.println(str.equals(str2));
        System.out.println(str.equalsIgnoreCase(str2));
    }

    @Test
    public void 字符串前缀后缀相等和包含判断() {
//        使用startWith（）和endWith（）方法
//        就是判断一个字符串是否已特定的字符串或字符开头或者结尾
//        有一个需要注意的是字符串的开头和结尾如果的“”的话也是对的
//        包含需要使用contain（）方法
        String str = "hello";

        System.out.println(str.startsWith("he"));
        System.out.println(str.startsWith("h"));
        System.out.println(str.startsWith(" "));
        System.out.println(str.startsWith(""));


        System.out.println(str.endsWith("o"));
        System.out.println(str.endsWith("lo"));
        System.out.println(str.endsWith("ol"));
        System.out.println(str.endsWith(""));

        System.out.println(str.contains("llo"));
        System.out.println(str.contains("loo"));
    }

}
