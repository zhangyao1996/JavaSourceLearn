package com.zy.test.designpattern.simplefactory;

import com.zy.test.designpattern.simplefactory.pizza.CheesePizza;
import com.zy.test.designpattern.simplefactory.pizza.GreekPizza;
import com.zy.test.designpattern.simplefactory.pizza.Pizza;

/**
 * Calender类使用简单工厂模式
 * 简单工厂模式(不属于23种设计模式)
 *1.简单工厂模式是属于创建型的模式，是工厂模式的一种。简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。
 * 2.简单工厂模式：定义了一个创建对象的类，由这个类来封装实例化的对象的行为
 *  @create 2020/4/18
 */
public class SimpleFactory {

    public Pizza createOrder(String orderType){
        Pizza pizza=null;
        System.out.println("使用简单工厂模式");
        if(orderType.equals("Greek")){
            pizza=new GreekPizza();
            pizza.setName("希腊pizza");
        }else if(orderType.equals("Cheese")){
            pizza=new CheesePizza();
            pizza.setName("芝士pizza");
        }
        return pizza;
    }
}


