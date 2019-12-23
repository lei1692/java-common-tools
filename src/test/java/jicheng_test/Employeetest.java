package jicheng_test;

import org.junit.Test;

import java.util.Date;
//在测试类中，创建员工和经理的对象，并使用setter方法进行赋值，最后调用类中的方法进行
//虽然复写了父类中的方法，但是父类中的方法还是存在的，想要使用可以使用supper关键字
public class Employeetest {
    @Test
    public void testPrint() {
        Employee em1 = new Employee();
        em1.setName("员工1");
        em1.setHireDay(new Date());
        em1.setSalary(100);
        em1.printInfo();

        Manager mag1 = new Manager();
        mag1.setName("经理1");
        mag1.setBonus(50);
        mag1.setHireDay(new Date());
        mag1.setSalary(200);;
        mag1.printInfo();

    }
}
