package com.zy.test.util;


import javax.swing.text.Segment;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap源码学习
 * @author zhangyao
 * @create 2020/4/7
 */
public class HashMapTest {
    public static void main(String[] args){
        test3();
    }

    /**
     * HashMap的线程不安全体现在会造成死循环、数据丢失、数据覆盖这些问题。
     * 其中死循环和数据丢失是在JDK1.7中出现的问题，在JDK1.8中已经得到解决，然而1.8中仍会有数据覆盖这样的问题。
     * jdk8种hashmap是数组,链表,红黑树（提高链表查询速率）
     *
     */
    public static void test1(){
        Map map=new HashMap();
        map.put(null,"s");

        System.out.println(map.put(null,"y"));
        System.out.println(map.get(null));

    }

    /**
     * 在JDK1.7中，当并发执行扩容操作时会造成环形链和数据丢失的情况,应该在初始化的时候设定预计容量避免扩容
     * 在JDK1.8中，在并发执行put操作时会发生数据覆盖的情况
     * hashmap线程不安全，可以加锁（1.Hashtable效率低  2.ConcurrentHashMap（分段锁））
     */
    public static void test2(){
        Map map=new Hashtable();

        Map map1=new ConcurrentHashMap();

        Segment segment=new Segment();

    }

    /**
     * 优秀hash算法
     * 快速，不可逆，敏感性，低碰撞率（速度，空间，碰撞性之间进行取舍）
     */
    public static void test3(){

        MyHashMap myHashMap=new MyHashMap();
        myHashMap.put("a","2");
        myHashMap.put("a","1");
        myHashMap.put("b","3");
        myHashMap.put("c","4");
        myHashMap.put("d","2");
        myHashMap.put("f","1");
        myHashMap.put("f","3");
        myHashMap.put("g","4");
        myHashMap.put("h","2");
        myHashMap.put("i","1");
        myHashMap.put("j","3");
        myHashMap.put("k","4");
        myHashMap.put("l","2");
        myHashMap.put("m","1");
        myHashMap.put("n","3");
        myHashMap.put("o","4");
        myHashMap.put("p","2");
        myHashMap.put("q","1");
        myHashMap.put("r","3");
        myHashMap.put("s","4");
        System.out.println(myHashMap);
    }
}
