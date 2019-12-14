package array;

import org.junit.Test;

import java.util.Arrays;

public class ArrayTest {
    @Test
    public void ArrayDeclare() {
        int[] arr;
        String[] str;
        int arr1[];
        String str1[];
//      静态初始化,我们自己不进行长度的确定，我们直接用{}来设置数组内的个数，由系统来确定数组的长度
//        int [] arr2 = new int[6]{1,2,3,4,5};
//        Error:(13, 33) java: 同时使用维表达式和初始化创建数组是非法的
        int [] arr2 = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(arr2));


//        动态初始化，先进行长度的确定，然后再依次赋值
//        如果没有进行初始化，那么系统会进行初始化
//        基本数据类型系统初始化为0.
//       引用数据类型系统初始化为null
//        boolean类型系统初始化为false
        int [] arr0 = new int[5];
        System.out.println(Arrays.toString(arr0));
        System.out.println(arr2.toString());
        boolean[] arr4 = new boolean[4];
        String[] arr5 = new String[3];
        Object[] arr6 =new Object[2];
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
        System.out.println(Arrays.toString(arr6));



    }
}
