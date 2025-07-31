
class MyThread implements Runnable{
    public void run(){
        //task for thread
        for(int i=1;i<=10;i++){
            System.out.println("value of i "+ i);
            try {
                // Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        AnotherThread t2=new AnotherThread();

        Thread thr=new Thread(t1);
     
        thr.start();
        t2.start();
    }
}



