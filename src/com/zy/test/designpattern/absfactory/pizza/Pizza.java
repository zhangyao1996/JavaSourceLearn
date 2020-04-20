package com.zy.test.designpattern.absfactory.pizza;

/**
 * pizza抽象实体类
 * @author zhangyao
 * @create 2020/4/18
 */
public abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake(){
        System.out.println(name+"bake");
    }

    public void cut(){
        System.out.println(name+"cut");
    }

    public void box(){
        System.out.println(name+"box");
    }

    public String getName() {
        return name;
    }

    public Pizza setName(String name) {
        this.name = name;
        return this;
    }
}
