package com.zy.test.util;


/**
 * 自己创建一个hashmap
 *
 * @author zhangyao
 * @create 2020/4/13
 */
public class MyHashMap<K, V> {

    private static final Integer CAPACITY = 16;//默认数组容量

    private Entry<K, V>[] table;//本质是数组

    private int size;//hashMap长度，不单单是数组长度，还有列表长度

    class Entry<K, V> {
        private K key;

        private V value;

        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


    //put
    public V put(K key, V value) {

//        Entry<K, V> entry = new Entry<>(key, value);
        if (table == null) {//第一次put，数组为空，给数组初始化
            inflate();
        }

        //对一个数进行hash值计算
        int hashCode = hash(key);
        //获取hashCode的数组下标
        int index = indexFor(hashCode);

        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {//对数组该位置的列表循环比较，找到key相同的entry,并且替换他
            if (entry.key.equals(key)) {
                entry.key = key;
                V oldValue=entry.value;
                entry.value=value;
                return oldValue;
            }
        }

        //存entry
        addEntry(index,key,value);
        return null;

    }


    public V get(K key){
        if (table == null) {//第一次put，数组为空，给数组初始化
            return null;
        }

        int hashCode=hash(key);
        int index=indexFor(hashCode);
        for(Entry<K,V> entry=table[index];entry!=null;entry=entry.next){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }
    private void addEntry(int index, K key,V value) {


        Entry<K,V> newEntry=new Entry<>(key, value,table[index]);//数组原有该位置的值赋给next

        table[index] =newEntry;//头插法

        size++;
    }

    //获取数组下标
    private int indexFor(int hashCode) {
        return hashCode % table.length;//模运算
    }

    //对一个树获取hash值
    private int hash(K key) {
        return key.hashCode();
    }

    //数组初始化
    private void inflate() {
        table = new Entry[CAPACITY];
    }
}
