package com.google.DesignPatterns.StrategyPattern.fact.impl;

import com.google.DesignPatterns.StrategyPattern.fact.FactApplyStrategy;

/**
 * @author wk
 * @Description:
 * @date 2019/12/26 14:51
 **/
public class JTFactApplyStrategy implements FactApplyStrategy {

    @Override
    public String toAddFact() {
        return "跳转交通银行";
    }
}
