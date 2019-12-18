package com.google.DesignPatterns.StrategyPattern;

/**
 * @author wk
 * @Description: 策略模式的应用场景？
 * @date 2019/12/18 16:50
 **/
public class TestStrategyPattern {

    public static void main(String[] args) {

        Context context;
        System.out.println("执行策略1---");
        context = new Context(new ActualStrategy1());
        context.excute();

        System.out.println("执行策略2---");
        context = new Context(new ActualStrategy2());
        context.excute();
    }
}
