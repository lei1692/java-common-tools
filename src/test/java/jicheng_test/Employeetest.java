package jicheng_test;

import org.junit.Test;

import javax.xml.crypto.Data;
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

    @Test
    public void 子类父类的构造器调用顺序3() {
//        在子类的有参构造函数中进行属性的赋值，使用setter方法，把传入的属性赋值给自己,因为子类中是没有属性的，所以
//        要使用setter把属性传给父类中的属性
        Manager mag = new Manager("经理1", new Date(),150,50);
        mag.printInfo();
    }

    @Test
    public void 子类父类的构造器调用顺序4() {
//        可以在子类构造器中传入参数中之后不使用setter方法，直接调用父类的有参构造方法来进行赋值
//        但是要注意自身的属性（域）是需要在子类构造器中赋值的
//        还有就是使用父类的有参构造函数的时候要写在第一行

        Manager mag = new Manager("经理1", new Date(),150,50);
        mag.printInfo();
    }

    @Test
    public void 多态() {
//        一个对象变量可以指向多个对象，但是有不会搞混各个对象之间方法的继承和调用
//        就是继承
//        总经理室继承了三个类，多以调用了三个类中的构造函数
//        虽然说都是使用了 ma.printInfo();但是因为多态，有动态绑定，所以不会执行错误
//        在最后一个printfinfo中调用的是父类中的printinfo，但是因为多态，里边的getname方法看的是
//        Mastermanager类中重写的getname方法。所以返回值会有【】
        Manager mag = new Manager("经理1", new Date(),150,50);
        Employee em2 = new Employee("员工2",new Date(),100);
        MasterManager mma = new MasterManager("总经理",new Date(),200,50);
        Employee ma = mag;       //可以吧实例化对象赋值给,一个对象变量，这个变量指向的对象是可以变的。
        ma.printInfo();
        ma = em2;
        ma.printInfo();
        ma = mma;
        ma.printInfo();
    }
}
