package com.google.DesignPatterns.StrategyPattern;

/**
 * @author wk
 * @Description:
 * @date 2019/12/18 16:49
 **/
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }


    public void excute() {
        strategy.doSomething();
    }
}
