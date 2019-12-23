package jicheng_test;

import java.util.Date;
//在父类中定义一些方法和域，定义一些私有的方法，提供setter和getter方法使外部能够修改
//再提供一个可以打印的方法
public class Employee {
    private String name;
    private Date hireDay;
    private Integer salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void printInfo(){
        StringBuilder tmp = new StringBuilder();
        tmp.append("姓名：");
        tmp.append(getName());
        tmp.append(",入职时间：");
        tmp.append(getHireDay());
        tmp.append(",薪水标准：");
        tmp.append(getSalary());

        System.out.println(tmp.toString());
    }



}
