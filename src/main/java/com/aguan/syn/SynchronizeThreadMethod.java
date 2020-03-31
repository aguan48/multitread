package com.aguan.syn;

/**
 * 同步方法的测试用例
 */
public class SynchronizeThreadMethod implements Runnable {
    private  int books = 5;
    @Override
    public void run() {
        this.BorrowBooks();
    }

    /**
     * 同步方法synchronized关键字加在了方法上
     */
    public synchronized void BorrowBooks(){
        for(int i=0;i<100 ;i++){
                if(books>0){
                  /*  try{
                        Thread.sleep(0);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }*/
                    System.out.println(Thread.currentThread().getName()+"borrow books：books="+books--);
                }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable =  new SynchronizeThreadBlock();
        new Thread(runnable).start();
        new Thread(runnable).start();
        Thread.sleep(1000);
    }
}
