import java.util.Scanner;

public class A1418 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            long x=sc.nextLong();
            long y=sc.nextLong();
            long k=sc.nextLong();

            long stick=k*y+k-1;
            long ans=(stick)/(x-1);
            if(stick%(x-1)!=0)ans++;
            ans+=k;
            System.out.println(ans);
        }
    }
}
