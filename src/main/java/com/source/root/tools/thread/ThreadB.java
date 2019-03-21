package com.source.root.tools.thread;

public class ThreadB extends Thread{

    private ThreadA threada;
    
    public ThreadB(ThreadA ta){
       this.threada = ta;
    }
    
    public void run(){
       System.out.println(Thread.currentThread().getName()+" is waitting.");
       synchronized(threada){
           try{
              threada.wait();
           }catch(InterruptedException e){
              e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+" "+this.threada.getNum());
       }
    }

}

