package com.zy.test.designpattern.simplefactory.pizza;

/**
 * @author zhangyao
 * @create 2020/4/18
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备奶酪pizza");
    }
}
