import java.util.Scanner;

public class A1875 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            long a=sc.nextLong();
            long b=sc.nextLong();
            long n=sc.nextInt();
            long count=0;
            for(int i=0;i<n;i++){
                int x=sc.nextInt();
                if(x>=a){
                    count+=a-1;
                }else{
                    count+=x;
                } 
            }
            count+=b;
            System.out.println(count);
        }
    }
}
