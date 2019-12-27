package jicheng_test.abstract_test;

import org.junit.Test;

public class AbstractTest {
    @Test
    public void 测试抽象类() {
        Person p1 = new Teacher();
        Person p2 = new Student();
        p1.getDescription();
        p2.getDescription();

        Teacher t1 = new Teacher();
        p1.getDescription();
        Teacher t2 = new Student();
        t2.getDescription();


    }
}
