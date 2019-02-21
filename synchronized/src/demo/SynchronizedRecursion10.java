package demo;

/**
 * 描述：可重入粒度测试：递归调用本方法
 * 证明了同一个方法是可重入的
 */
public class SynchronizedRecursion10 {

    int a = 0;

    public static void main(String[] args){
        SynchronizedRecursion10 synchronizedRecursion10 =
                new SynchronizedRecursion10();
        synchronizedRecursion10.method1();
    }

    public synchronized void method1(){
        System.out.println("这是method1，a = " + a);
        if (a==0){
            a++;
            method1();
        }
    }
}
