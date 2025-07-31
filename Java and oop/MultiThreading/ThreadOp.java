 class ThreadOp {
    public static void main(String[] args) {
        System.out.println("sum is "+(78+12));
        Thread t= Thread.currentThread();
        String tname=t.getName();
        System.out.println("current thread name "+tname);
        //setname
        t.setName("MyMain");
        String tnameNew=t.getName();
        System.out.println("current thread New name "+tnameNew);
    }
}
