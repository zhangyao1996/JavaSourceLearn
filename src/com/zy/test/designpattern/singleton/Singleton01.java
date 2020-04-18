package com.zy.test.designpattern.singleton;

/**
 * 单例模式（通过创建私有构造函数这样是可以保证单例）
 * 1.单例模式保证类系统内存中该类只存在一个对象，节省了系统资源，对于一下需要频繁创建销毁的对象，使用单例模式可以提高系统性能
 * 2.当想实例化一个单例类的对象，必须要记住使用相应的获取对象的方法，而不是使用new
 * 3.单例模式使用的场景：需要频繁使用创建和销毁的对象，创建时耗时过多或耗费资源过多（即：重量级对象），但又经常使用的对象，
 * 工具类对象，频繁访问数据库或文件的对象（数据源，session工厂等）
 * @author zhangyao
 * @create 2020/4/17
 */
public class Singleton01{

    public static void main(String[] args) {
        Singleton6 singleton=Singleton6.INSTANCE;
        Singleton6 singleton1=Singleton6.INSTANCE;
        singleton.sayOk();
        System.out.println(singleton==singleton1);
    }
}

/**
 * 饿汉式(静态变量)
 * 步骤如下：
 * 1.构造器私有化
 * 2.类的内部创建对象
 * 3.向外暴露一个静态的公共方法。getInstance
 *
 * 优缺点说明
 * 1）优点：这种方法比较简单，就是在类加载的时候就完成实例化。避免了线程同步问题
 * 2）缺点：在类加载的时候就完成实例化，没有达到Lazy Loading 的效果。如果从开始至终从未使用过这个实例，则会造成内存浪费
 * 3）这种方式基于classload机制避免了多线程的同步问题，不过instance在类加载时就实例化，在单例模式中大多数都是调用getInstance
 * 方法，但是导致类加载的原因有很多种，因此不能确定有其他的方式（或者其他的静态方法）导致类装载(例如：通过Class.forName()方法动态加载，会默认执行初始化块（static{}）)
 * ,这时候初始化instance就没有达到Lazy Loading的效果
 * 4)结论：可能造成内存浪费
 */
class Singleton{


    //1.构造器私有化，防止外部能new
    private Singleton(){
        System.out.println("ssss======");
    }

    //本类内部创建对象实例
    private static final Singleton instance=new Singleton();

    //提供一个共有的静态方法,返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}


/**
 * 饿汉式（静态代码块）与饿汉式(静态变量)一样
 */
class Singleton1{


    //1.构造器私有化，防止外部能new
    private Singleton1(){
        System.out.println("ssss======");
    }

    //本类内部创建对象实例
    private static final Singleton1 instance;

    static {
        System.out.println("sss++++");
        instance=new Singleton1();
    }

    //提供一个共有的静态方法,返回实例对象
    public static Singleton1 getInstance(){
        return instance;
    }
}



/**
 * 懒汉式（线程不安全）
 * 1.起到Lazy Loading的效果，但是只能在单线程下使用
 * 2.如果在多线程下，一个线程进入了if判断，还未来得及加载，另外一个线程也通过了这个判断，这时便会多实例。
 * 所以在多线程下不可使用这种方式
 * 3.在实际开发中，不要使用该方法
 */
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {

    }

    //提供一个静态的共有的方法，当使用这个方法时，才去创建instance
    public static Singleton2 getInstance() {

        if (instance == null) {
            instance=new Singleton2();
            return instance;
        } else {
            return instance;
        }
    }

}

/**
 * 懒汉式（线程安全,同步方法）
 * 解决线程安全，但是效率太低，每次执行getInstance（）方法都要进行同步。实际开发中，不推荐使用
 */
class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {

    }

    //加入方法锁，在单机下是线程安全
    public static synchronized Singleton3 getInstance() {

        if (instance == null) {
            instance=new Singleton3();
            return instance;
        } else {
            return instance;
        }
    }

}


/**
 * 双重检查(推荐使用)
 * 进行两次instance==null判断，线程安全；延迟加载；效率较高
 */
class Singleton4 {
    //volatile立即更新到主存(实现线程的可见性：说的是一个线程如果更改了某个变量的值，其他线程能够立刻知道这个变量更改后的值)
    private static  volatile Singleton4 instance;

    private Singleton4() {

    }

    //加入方法锁，在单机下是线程安全
    public static Singleton4 getInstance() {

        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }else {
            System.out.println("");
        }
        return instance;
    }

}

/**
 * 静态内部类(推荐使用)
 *
 *1)这种方式采用类加载的机制保证初始化实例时只有一个线程
 * 2）静态内部类方式采用在当类Singleton5被装载时并不会立即实例化，而是在需要实例化的时候
 * ，调用getInstance方法,才会装载InnerSingleton5类,从而完成Singleton5的实例化
 * 3）类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮我们保证了线程安全
 * 能保证线程安全和Lazy Loading
 */
class Singleton5 {

    private Singleton5(){

    }
    private static class InnerSingleton5{
       static final Singleton5 INSTANCE=new Singleton5();
    }

    public static Singleton5 getInstance() {
        return InnerSingleton5.INSTANCE;
    }

}

/**
 * 枚举类型（推荐使用）
 * 这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步，而且还能防止反序列化重新创建新的对象
 */
enum Singleton6{
    INSTANCE;
    public void sayOk(){
        System.out.println("ok====");
    }
}


