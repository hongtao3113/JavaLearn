package com.google.DesignPatterns.StrategyPattern.fact.impl;

import com.google.DesignPatterns.StrategyPattern.fact.FactApplyStrategy;

/**
 * @author wk
 * @Description:
 * @date 2019/12/26 17:10
 **/
public class ZGFactApplyStrategy implements FactApplyStrategy {

    @Override
    public String toAddFact() {
        return "跳转中国银行";
    }
}
