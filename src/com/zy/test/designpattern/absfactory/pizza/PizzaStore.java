package com.zy.test.designpattern.absfactory.pizza;

import com.zy.test.designpattern.absfactory.order.BJFactory;
import com.zy.test.designpattern.absfactory.order.OrderPizza;

import java.util.Calendar;

/**
 *相当于客户端，发起订购
 * @author zhangyao
 * @create 2020/4/18
 */
public class PizzaStore {

    public static void main(String[] args) {
        Calendar calender=Calendar.getInstance();

        OrderPizza orderPizza=new OrderPizza();
        orderPizza.setFactory(new BJFactory());
    }
}
