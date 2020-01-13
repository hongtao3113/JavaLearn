package com.google.DesignPatterns.StrategyPattern.fact.impl;

import com.google.DesignPatterns.StrategyPattern.fact.FactApplyStrategy;

/**
 * @author wk
 * @Description:
 * @date 2019/12/24 13:59
 **/
public class GdFactApplyStrategy implements FactApplyStrategy {

    @Override
    public String toAddFact() {
        return "跳转光大银行";
    }
}
