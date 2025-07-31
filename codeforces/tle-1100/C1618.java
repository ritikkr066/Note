import java.util.Scanner;

public class C1618 {

    public static long gcd(long a,long b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            long g1=0,g2=0;
            for(int i=0;i<n;i++){
                if(i%2==0){
                    g1=gcd(arr[i],g1);
                }else{
                    g2=gcd(arr[i],g2);
                }
            }
            boolean flag1=false,flag2=false;
           
            for(int i=0;i<n;i++){
                if(i%2==0){
                    if(arr[i]%g2==0){
                        flag1=true;
                        break;
                    }
                }
            }
            if(!flag1){
                System.out.println(g2);
                continue;
            }
            for(int i=0;i<n;i++){
                if(i%2==1){
                    if(arr[i]%g1==0){
                        flag2=true;
                        break;
                    }
                }
            }
            if(!flag2){
                System.out.println(g1);
            }else{
                System.out.println(0);
            }
        }
    }
}
