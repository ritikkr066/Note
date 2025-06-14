import java.util.Scanner;

public class B1411 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            long n=sc.nextLong();
            boolean flag=false;
            while(!flag){
                String s=String.valueOf(n);
                int i=0;
                for(i=0;i<s.length();i++){
                    if(s.charAt(i)-'0'>0 && n%(long)(s.charAt(i)-'0')!=0){
                        n++;
                        break;
                    }
                    
                }
                if(i==s.length()){
                    flag=true;
                }
            }
            System.out.println(n);
        }
    }
}
