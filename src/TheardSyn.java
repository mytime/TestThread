/**
 * 同步有两种方式实现
 * 使用关键字:synchronized
 * 1 同步代码块
 * 2 同步方法
 */


    //新建一个类实现Runnable接口
    class MyThreadDemo implements Runnable{

        //5张车票
        private int ticket = 5;

        @Override
        public void run() {

            for (int i = 0; i < 10 ; i++) {

               //2 同步方法
                tell();

                //1 同步代码块
                //同步数据 this:自己
//                synchronized (this){
//                    if(ticket>0){
//
//                        try {
//                            //等待500毫秒
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println("车票"+ticket--);
//                    }
//                }


            }

        }

    //2 同步方法
    public synchronized void tell(){
        if(ticket>0){

            try {
                //等待500毫秒
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("车票"+ticket--);
    }

    }}

public class TheardSyn {
    public static void main(String[] args){

        //线程接口对象
        MyThreadDemo m = new MyThreadDemo();

        //三个窗口同时售卖 三个线程

        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        Thread t3 = new Thread(m);

        t1.start();
        t2.start();
        t3.start();


    }
}
