package jicheng_test.Interface;

public interface Interface2 {
    void method2();
    default void printf(){
        System.out.println("我是一个默认方法");
    }

}
