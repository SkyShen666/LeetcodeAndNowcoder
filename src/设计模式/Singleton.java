package 设计模式;

public class Singleton {
    private static volatile Singleton instance;

    /**
     * 构造器私有（为了 懒加载）
     * 这样其他类中，需要使用SingletonDemo对象就不能：SingletonDemo s = new SingletonDemo()
     * 只能通过SingletonDemo.getInstance()方法。
     * 这种滞后构建的方式，就叫“懒加载”
     * 懒加载优点：
     * 只有真正需要使用再去构建，节省资源。
     */
    private Singleton() {
        System.out.println(Thread.currentThread().getName() + " 构造方法");
    }

    /**
     * DCL(double check lock)
     * 双重检锁机制
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(); // 在其他类中，不能new，只能通过Singleton.getInstance()获取
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Singleton.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
