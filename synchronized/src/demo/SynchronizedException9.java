package demo;

/**
 * 描述：方法抛异常后，会释放锁。展示不抛出异常前和
 * 抛出异常后的对比：一旦抛出异常，第二个线程会立刻
 * 进入同步方法，意味着锁已经释放。
 */
public class SynchronizedException9 implements Runnable{
    static SynchronizedException9 instance =
            new SynchronizedException9();

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    public synchronized void method1(){
        System.out.println("我是非静态加锁的方法1。我叫" +
                Thread.currentThread().getName());
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        throw new RuntimeException();
//        System.out.println(Thread.currentThread().getName() +
//                "运行结束");
    }

    public synchronized void method2(){
        System.out.println("我也是非静态加锁的方法2。我叫" +
                Thread.currentThread().getName());
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                "运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while ((t1.isAlive() || t2.isAlive())){}
        System.out.println("finished");
    }
}
