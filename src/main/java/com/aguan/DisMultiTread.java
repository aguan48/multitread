package com.aguan;

/**
 * 继承Tread和实现Runnable接口有何不同
 */
public class DisMultiTread {
    /**
     * 继承Thread类建立简单的线程
     */
    static  class ExtendTread1 extends Thread {
        private int s = 5;
        //覆盖父类的run方法
        public void run(){
            for(int i=0 ;i<5;i++){
                System.out.println(getName()+"的值："+s--);
            }
        }
    }
    /**
     * 实现Runnable接口实现线程的类
     */
    static class ImplenmentRunnable1 implements Runnable{

        private int s = 5;
        //由于实现的接口没有线程操作的方法，所以用Tread类直接调用线程中的静态方法。
        @Override
        public void run() {
            for(int i=0 ;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"的值："+s--);            }

        }
    }
    public static void main(String[] args)  {
        //继承线程类
       // new ExtendTread1().start();
       // new ExtendTread1().start();
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        ImplenmentRunnable1 implenmentRunnable1 = new ImplenmentRunnable1();
        //实现Runable接口的方式 传入同一个引用 共享代码块
        new Thread(implenmentRunnable1).start();
        new Thread(implenmentRunnable1).start();
    }
}
