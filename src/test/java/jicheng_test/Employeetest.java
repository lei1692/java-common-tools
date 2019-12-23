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

    @Test
    public void 子类父类的构造器调用顺序1() {
//    在父类中的有参构造函数知识对输入的参数进行了对象属性的赋值，并没有进行输出
//    所以想要输出还是要调用打印函数吧
//    经理中没有进行父类有参构造方法的调用，所以系统默认调用父类的有餐构造方法
        Employee em2 = new Employee("员工2",new Date(),100);
//        em2.setName("员工2");
//        em2.setHireDay(new Date());
//        em2.setSalary(100);
        em2.printInfo();

        System.out.println("=============================================");

        Manager mag2 = new Manager();
        mag2.setName("经理1");
        mag2.setBonus(50);
        mag2.setHireDay(new Date());
        mag2.setSalary(200);;
        mag2.printInfo();
    }

    @Test
    public void 子类父类的构造器调用顺序2() {
//        创建父类的时候，调用有参构造，在有参构造里边直接对传入的参数进行赋值，不用使用setter了
        Employee em2 = new Employee("员工2",new Date(),100);
        em2.printInfo();

        System.out.println("=============================================");

//        使用有参构造函数来创建manager，但是在创建子类之前没有调用父类的有参构造，
//        那么会自动调用父类的无参构造再对其他的属性进行赋值
        Manager mag2 = new Manager(50);
        mag2.setName("经理2");
        mag2.setSalary(200);
        mag2.setHireDay(new Date());
        mag2.printInfo();
    }
}
