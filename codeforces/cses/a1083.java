import java.util.Scanner;

public class a1083{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextInt();
        long num=0;
        for(int i=0;i<n-1;i++){
            int x=sc.nextInt();
            num+=x;
        }

        long ans=(long)(n*(n+1))/2-num;
        System.out.println(ans);
    }
}