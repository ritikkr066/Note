import java.util.Scanner;

public class t1069 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int count=1;
        int max=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                count=1;
            }
            max=Math.max(max,count);
        }
        System.out.println(max);
    }
}
