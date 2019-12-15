package array;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {
    @Test
    public void arrayTest() {
//        数组的定义
        int[] arr;
        int arr1[];
        String[] arr2;
        String arr3[];

//        数组的初始化
//        静态初始化，直接用大括号{}进行赋值，由系统来进行长度的判断
//        使用new创建对象之后直接用大括号进行赋值
        int[] arr4 = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr4));
        int[] arr5 = new int[]{1,2,3};
        System.out.println(Arrays.toString(arr5));

//        动态初始化，在初始化的时候指明长度，之后再进行赋值

        String str[] = new String[3];
        str[0] = "one";
        str[1] = "two";
        str[2] = "three";
        System.out.println(Arrays.toString(str));

//        如果不指明长度的话，系统会自动进行赋值

        int[] arr_1 = new int[5];
        String[] arr_2 = new String[5];
        boolean[] arr_3 = new boolean[5];
        Object[] arr_4 = new Object[5];
        System.out.println(Arrays.toString(arr_1));
        System.out.println(Arrays.toString(arr_2));
        System.out.println(Arrays.toString(arr_3));
        System.out.println(Arrays.toString(arr_4));
//        八种基本数据类型是 0
//        引用类型是null
//        boolean类型是false
    }

    @Test
    public void arrayBianLi() {
        //    示例：分别使用上述三种方式遍历数组 `Integer[] arr = {1, 2, 3, 4, 5};`

        Integer[] arr = {1, 3, 6, 7, 2};
        System.out.println("1. for循环使用数组下标");
        for(int index = 0;index<arr.length;index++){
//            System.out.println("下标是：" + index +  "  值是：" + arr[index]);
            System.out.println(String.format("下标是：%d  值是：%d",index,arr[index]));
        }

        System.out.println("2. for each循环");
        int index = 0;
        for(int val:arr){
//            System.out.println("第"+index+"位数值为"+val);
            System.out.println(String.format("第%d次数值为%d",index,val));
            index++;
        }
        System.out.println("3. Java 8新增的 Lambda 表达式");
        Arrays.asList(arr).forEach(val->{
            System.out.println("值是："+val);
            if(val%2==0) System.out.println("    是偶数");
            else System.out.println("    是奇数");
        });


    }

    @Test
    public void testArraysAslist() {
        String[] str= {"hello","world","welcom"};
        System.out.println(Arrays.asList(str));
        System.out.println(Arrays.toString(str));

    }

    @Test
    public void testCopy() {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        Integer[] arr2 = {8,9,10};
        // 拷贝数组 arr1 的前 3 个元素,生成一个新的数组
        Integer[] arr3 = new Integer[3];
        arr3[0] = arr1[0];
        arr3[1] = arr1[1];
        arr3[2] = arr1[2];
        System.out.println(Arrays.toString(arr3));
        Integer[] arr11 = Arrays.copyOf(arr1,3);
        System.out.println(Arrays.toString(arr11));


        // 拷贝数组 arr1 的第 1 位到第 3 位的元素（不包括第 3 位）
        Integer[] arr22 = Arrays.copyOfRange(arr1,arr1.length-4,arr1.length);
        System.out.println(Arrays.toString(arr22));
        arr22 = Arrays.copyOfRange(arr1,0,arr1.length);
        System.out.println(Arrays.toString(arr22));
        // 拷贝数组 arr2 的后 3 位到 arr1 到后 3 位,类似于替换，把目标数组的第几位开始替换到另一个数组的第几位，长度是**
//        把arr2的第0位开始，长度是2，替换到（拷贝到）arr1的第2位开始，长度是2
        System.arraycopy(arr2,0,arr1,2,3);
        System.out.println(Arrays.toString(arr1));

    }

    @Test
    public void testFill() {
//        定义一个大小为 10 的 int 数组，并将数组全部初始化为指定的值 5，打印数组；
//        然后将数组后 3 为赋值为 3，再次打印数组。
        int[] arr1 = new int[]{5,5,5,5,5,5,5,5,5,5};
        int[] arr2 = new int[10];
        for(int index = 0;index<10;index++){
            arr2[index]=5;
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
//        下标的最大值是长度-1
        for(int index=arr1.length-1;index>arr1.length-4;index--){
            arr1[index]=3;
        }
        System.out.println(Arrays.toString(arr1));
        String[] arr11 = new String[5];
        Arrays.fill(arr11,"5");
        System.out.println(Arrays.toString(arr11));
        Arrays.fill(arr11,arr11.length-3,arr11.length,"9");
        System.out.println(Arrays.toString(arr11));


    }
}