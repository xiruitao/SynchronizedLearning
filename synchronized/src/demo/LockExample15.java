package demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：展示Lock的方法
 */
public class LockExample15 {
    public static void main(String[] args){
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        lock.tryLock();
//        lock.tryLock(10, TimeUnit.SECONDS);
    }
}
