interface Cow {
    default void sound(){
        System.out.println("Cow speak");
    }
}

 interface Dog{
    default void sound(){
        System.out.println("Dog speak");
    }
 }

 class Tommy implements Cow,Dog{
    public void sound(){
        Dog.super.sound();
    }
 }
public class main{
    public static void main(String[] args) {
       Tommy t= new Tommy();
        t.sound();
       return;
    }
}