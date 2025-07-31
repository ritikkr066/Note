import java.util.Scanner;

public class B1826 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int ans=0;
            for(int i =0;i<(n/2);i++){
                ans = gcd(ans,Math.abs(arr[i]-arr[n-1-i]));
            }
            System.out.println(ans);
        }
    }
    public static int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
}
