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

    @Test
    public void 字符串的查找() {
//        假如说只有一个参数，就是从头开始找这个字符串，有就返回第一个出现的下标，没有返回-1
//        可以利用循环来查找每个字符串的位置
//        需要注意的就是，如果开始查找的下标大于或者小于字符串的长度是可以的
        String str = "heollo worldo";
        System.out.println(str.indexOf(2,3));
        System.out.println(str.indexOf("o",3));
        System.out.println(str.indexOf("llo"));

//        先从头开始查找，找到了之后，从这个下标的后一位开始查找，
//        一直到查找的结果是-1就是没有查找到
        int i=0;
        for(int index = 0;index<str.length();index++){
            int at = str.indexOf("o",i);
            if (at==-1) break;
            System.out.println("字符串o出现的位置"+str.indexOf("o",i));
            i=at+1;
        }

        i=-2;
        do{
            int at = str.indexOf("o",i);
            if(at==-1) break;
            System.out.println(String.format("o出现的位置是%d",str.indexOf("o",i)));
            i=at+1;
        }while(true);

//        从后往前找也是一样的，只不过多了一个last
        i=str.length();
        do{
            int at = str.lastIndexOf("o",i);
            if(at==-1) break;
            System.out.println(String.format("第 %d 为出现的是小写字母o",str.lastIndexOf("o",i-1)));
            i = at-1;
        }while(true);
    }

    @Test
    public void 字符串的查找并替换() {
//        使用replace（）方法和replaceAll（）方法
//        但是后边的方法是使用正则表达式的
        String str ="hello,world";
        System.out.println(str.replace('o','O'));
        System.out.println(str.replaceAll("o","O"));
    }

    @Test
    public void 字符串的去除空格和大小写的转换() {
//        使用trim（）方法，可以去掉前后的空格，但是不能去掉中间的空格使用replace（）方法，
//        直接可以吧所有的空格替换掉
        String str = "he llo ,w o r l a ";
        String str1 = "   hello,world   ";

        System.out.println(str.replace(" ",""));
        System.out.println(str1.replace(" ",""));
        System.out.println(str1.trim());

//        大小写的转换使用

        System.out.println(str1.trim().toUpperCase());
        String str3 = "HOLLO";
        System.out.println(str3.toLowerCase());
    }

    @Test
    public void 字符串中的空串和null串() {
//        空串就是一个长度为0，内容为空的字符串
        String str = "";
        System.out.println(String.format("%s是空串",str));
//        没有进行初始化，没有指向任何对象
        String str1 = null;
        System.out.println(String.format("%s是null串",str1));
    }

    @Test
    public void StringBuffer和StringBuer() {
//        使用这两个进行创建新对象字符串的时候默认的内层数组长度是16，
//        如果，进行赋值的长度大于16的话，就会抛弃刚创建的对象，
//        重新创建一个新数组，然后把原来数组里的内容拷贝到新数组中
//        这样会增加内存的开销
//        StringBuilder中可以指定容量，如果可预估容量的话，可指定容量的大小，
//        这样可以避免多次扩容，减小开销
        StringBuilder str = new StringBuilder(17);
        System.out.println(str.length());
    }

    @Test
    public void 使用builder和buffer进行拼接() {
//        使用StringBuilder进行创建，之后可以通过append来进行添加。
//        可以通过length（）来进行长度的设定
        StringBuilder str = new StringBuilder();
        str = str.append("hello");
        System.out.println(str);
        str = str.append(" world.");
        System.out.println(str.toString());
        System.out.println(str.length());
        str.setLength(9);
        System.out.println(str.toString());
        str.setLength(30);
        System.out.println(str.toString());
    }
}
