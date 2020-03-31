package com.aguan;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现callable接口，进行线程的创建
 */
public class ImplenmentsCallableThread {

    static class CallableDemo implements Callable {

        //实现callable接口，返回线程操作完的数据
        @Override
        public Object call() {
            return "12121";
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //此类实现了Runnable接口和future接口（线程操作结果在此接口定义），并且此类创建的时候可以传入的参数为Runnable加返回结果类型和Callable
        FutureTask<String> futureTask = new FutureTask<String>(new CallableDemo());
        Thread thread = new Thread(futureTask);//同样需要放到Tread类进行创建
        thread.start();//启动该线程
        System.out.println(futureTask.get());//获取线程返回参数
    }
}
