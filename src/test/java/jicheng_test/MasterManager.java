package jicheng_test;

import java.util.Date;

public class MasterManager extends Manager {
    public MasterManager(){}


    @Override
    public String getName() {
        return "[" + super.getName() + "]" ;
    }

    public MasterManager(String name, Date hireDate, Integer salary, Integer bonus){
        super(name,hireDate,salary,bonus);
        System.out.println("执行了MasterManager中的有参构造函数");
    }

}
