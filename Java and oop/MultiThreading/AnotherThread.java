class AnotherThread extends Thread {
    public void run(){
        for(int i=10;i>=0;i--){
            System.out.println("i "+ i);
            try {
                // Thread.sleep(1500);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
