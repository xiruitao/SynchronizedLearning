package demo;

/**
 * 描述：对象锁示例1，代码块形式
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 instance1 =
            new SynchronizedObjectCodeBlock2();
    static SynchronizedObjectCodeBlock2 instance2 =
            new SynchronizedObjectCodeBlock2();
    @Override
    public void run() {
        synchronized (instance1) {
            System.out.println("我是对象锁的代码块形式。我叫" +
                    Thread.currentThread().getName());
            synchronized (instance2){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "运行结束。");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while ((t1.isAlive() || t2.isAlive())){}
        System.out.println("finish");
    }
}
