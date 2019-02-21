package demo;

/**
 * 描述：类锁的第二种形式：synchronize(*.class)
 */
public class SynchronizedClassClass5 implements Runnable {
    static SynchronizedClassClass5 instance1 =
            new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 =
            new SynchronizedClassClass5();

    @Override
    public void run() {
        try{
            method();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void method() throws InterruptedException {
        synchronized (SynchronizedClassClass5.class){
            System.out.println("我是类锁的第二种形式：synchronize(*.class)。我叫" +
                    Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while ((t1.isAlive() || t2.isAlive())){}
        System.out.println("finished");
    }
}
