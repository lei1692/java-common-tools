package jicheng_test;

import javax.xml.crypto.Data;
import java.util.Date;

//子类继承父类，有自己独有的方法和属性，可以重写父类的方法，拥有父类所有非private和未重写的方法
//自己定义属性之后，自己提供方法使外部能够进行修改
public class Manager extends Employee {
    private Integer bonus;
    public Manager(){
        System.out.println("调用了Manager的午餐构造函数");
    }
    public Manager(Integer bonus){
        System.out.println("调用了Manager的有餐构造函数");
        this.bonus = bonus;
    }
    public Manager(String name, Date hireDay, Integer salary,Integer bonus){
        System.out.println("调用了Manager的有参构造函数");
        setSalary(salary);
        setName(name);
        setHireDay(hireDay);
        setBonus(bonus);
    }
    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
    @Override   //子类可以覆盖父类方法，自己进行重写。我们称为复写或者覆盖，可以使用@Override注解
    public Integer getSalary(){
        if(bonus == null) return super.getSalary();
        return super.getSalary() + bonus;
    }
}
