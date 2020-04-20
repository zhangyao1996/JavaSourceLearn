package com.zy.test.designpattern.absfactory.order;

import com.zy.test.designpattern.absfactory.pizza.BJPepperPizza;
import com.zy.test.designpattern.absfactory.pizza.Pizza;

import java.util.Objects;

/**
 * @author zhangyao
 * @create 2020/4/20
 */

/**
 * 工厂子类
 */
public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza=null;
        if(Objects.equals("Pepper",orderType)){
            pizza=new BJPepperPizza();
        }
        return pizza;
    }
}
