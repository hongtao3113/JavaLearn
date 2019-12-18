package com.google.DesignPatterns.StrategyPattern;

/**
 * @author wk
 * @Description:
 * @date 2019/12/18 16:48
 **/
public class ActualStrategy2 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("---具体策略 2---");
    }
}
