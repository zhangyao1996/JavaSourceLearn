package com.zy.test.designpattern.absfactory.order;

import com.zy.test.designpattern.absfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 服务端，完成订购
 * @author zhangyao
 * @create 2020/4/18
 */
public class OrderPizza {

    AbsFactory absFactory;

    public void setFactory( AbsFactory absFactory) {
        Pizza pizza = null;
        String orderType = "";
        do {
            orderType=getOrderType();
            pizza = absFactory.createPizza(orderType);
            if (pizza != null) {
                pizza.cut();
                pizza.prepare();
            } else {
                System.out.println("pizza不存在");
            }
        } while (true);
    }

    private String getOrderType() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入披萨类型：");
        String str = null;
        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
