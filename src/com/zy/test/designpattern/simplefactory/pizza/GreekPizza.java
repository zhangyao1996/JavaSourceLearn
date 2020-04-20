package com.zy.test.designpattern.simplefactory.pizza;

/**
 * @author zhangyao
 * @create 2020/4/18
 */
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备希腊pizza");
    }
}
