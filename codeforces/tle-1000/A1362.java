import java.util.Scanner;

public class A1362 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            long a=sc.nextLong();
            long b=sc.nextLong();

            long min=Math.min(a,b);
            long max=Math.max(a,b);

            if(min==max){
                System.out.println(0);
            }else if(max % min != 0 || (max / min & (max / min - 1)) != 0){
                System.out.println(-1);
            }else{
                long div=max/min;
                long x=0;
                while(div>1){
                    x++;
                    div/=2;
                }
                long ans=0;
                while(x>=3){
                    ans++;
                    x-=3;
                }
                while(x>=2){
                    ans++;
                    x-=2;
                }
                ans+=x;
                System.out.println(ans);
            }
        }
    }
}
