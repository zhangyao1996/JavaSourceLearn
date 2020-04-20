package com.zy.test.designpattern.absfactory.order;

import com.zy.test.designpattern.absfactory.pizza.Pizza;

/**
 * 抽象工厂模式抽象层
 */
public interface AbsFactory {

    public Pizza createPizza(String orderType);

}
