package jicheng_test.Interface;

public class InterfaceImplement implements Interface ,Interface2{
    @Override
    public void method(){
        System.out.println("我是一个方法");
    }

    @Override
    public void method2() {
        System.out.println("我是方法2");
    }
}
