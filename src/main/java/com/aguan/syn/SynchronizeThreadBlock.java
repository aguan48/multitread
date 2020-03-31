package com.aguan.syn;

/**
 * 同步代码块实现线程间的同步，一般将当前类做同步对象
 */
public class SynchronizeThreadBlock implements Runnable{
    private  int books = 5;
    @Override
    public void run() {
        for(int i=0;i<100 ;i++){
            synchronized (this){//同步代码块
                if(books>0){
                  /*  try{
                        Thread.sleep(0);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }*/
                  //由于实现的接口，接口中没有获取线程名字的方法，所有用Thread中的方法。
                    System.out.println(Thread.currentThread().getName()+"borrow books：books="+books--);
                }
            }

        }
    }
//启动两个线程
    public static void main(String[] args) throws InterruptedException {
       Runnable runnable =  new SynchronizeThreadBlock();
       //两个线程用了同一个引用，操作的内存空间是一样的。所以books是正常借出的。
       new Thread(runnable).start();
        new Thread(runnable).start();
        Thread.sleep(1000);//主线程休眠1秒
    }
}
