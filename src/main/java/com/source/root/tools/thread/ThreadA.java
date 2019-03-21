package com.source.root.tools.thread;

public class ThreadA extends Thread{

    public int num = 0;

    public void run(){

       synchronized (this){//在此类对象上实现同步，this指代当前对象

           for(int i = 0 ; i < 10 ; ++i){

              this.num = i;
              try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
              System.out.println(getNum());
           }
           try{

               Thread.sleep(3000);//如果ThreadB的三个示例线程在还没有进入等待状态之前就受到了notifyall的信号

               //那将会发生严重后果，因为调用notifyall的线程只可以调用一次notifyall，那造成等待的线程将永远等待下去

               //所以在此处让它睡一小会，让其他线程有时间进入等待状态。

               //不然会收到

            }catch(InterruptedException e){

               e.printStackTrace();

            }


           notifyAll();//通知所有在这个对象上等待的线程开始执行，在这里就是通知TestNotify主线程开始执行
           //notify();

       }

    }

    public int getNum(){

       return this.num;

    }

}


