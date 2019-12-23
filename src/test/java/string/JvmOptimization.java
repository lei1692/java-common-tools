package string;

import org.junit.Test;

public class JvmOptimization {
    @Test
    public void JVM对字符串拼接的优化1() {
        String str = "hello " + " world";
        System.out.println(str);

    }

    @Test
    public void JVM对字符串拼接的优化2() {
        String str = "hello world";
        System.out.println(str);
    }
}
