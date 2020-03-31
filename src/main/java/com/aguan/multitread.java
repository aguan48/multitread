package com.aguan;


/**
 * 线程创建的两种方式 * 1.继承Tread类
 * 2.实现Runable接口
 */
public class multitread {
    /**
     * 继承Thread类建立简单的线程
     */
    static  class ExtendTread1 extends Thread {
        public ExtendTread1(String treadName){
            setName(treadName);
        }
        //覆盖父类的run方法
        public void run(){
            System.out.println("我的第一个线程:"+getName());

        }
    }
    /**
     * 实现Runnable接口实现线程的类
     */
    static class ImplenmentRunnable1 implements Runnable{

       //由于实现的接口没有线程操作的方法，所以用Tread类直接调用线程中的静态方法。
        @Override
        public void run() {
            System.out.println("我的第一个线程:"+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        //继承线程类
       new  ExtendTread1("first thread extends Thread class!").start();
       //实现Runable接口的方式
       new Thread(new ImplenmentRunnable1(),"first thread implment Runnable interface!").start();
    }
}
