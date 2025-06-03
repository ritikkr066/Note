import java.util.Scanner;

public class A1559 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            long ans=arr[0];
            for(int i=1;i<n;i++){
                ans&=arr[i];
            }
            System.out.println(ans);
        }
    }
}
