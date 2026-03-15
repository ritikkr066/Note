import java.util.Scanner;

public class D1872 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            long n=sc.nextLong();
            long x=sc.nextLong();
            long y=sc.nextLong();

            long countX= n/x; //3
            long countY= n/y; // 2
            long lcm = (x*y)/gcd(x,y);
            long common=n/lcm; //1

            long ans=0;
            // for(long i=n;i>n-countX+common;i--){
            //     ans+=i;
            // }
            ans=sum(n)-sum(n-countX+common)-sum(countY-common);

            // for(int i=1;i<=countY-common;i++){
            //     ans-=i;
            // }
            System.out.println(ans);
        }
    }

    public static long sum(long n){
        return n*(n+1)/2;
    }

    public static long gcd(long x,long y){
        if(x%y==0)return y;
        return gcd(y,x%y);
    }
}
