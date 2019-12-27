package jicheng_test.Interface;

import org.junit.Test;

public class InterfaceTest {
    @Test
    public void 实例化测试() {
        Interface i1 = new InterfaceImplement();
        i1.method();
        Interface.print();
        System.out.println(Interface.Max_count);
        System.out.println(InterfaceImplement.Max_count);
        System.out.println(i1.Max_count);

        Interface2 i2 = new InterfaceImplement();
        i2.method2();
        i2.printf();
        System.out.println(i1 instanceof Interface);
        System.out.println(i1 instanceof Interface2);

    }
}
