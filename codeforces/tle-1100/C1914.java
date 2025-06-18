import java.util.Scanner;

public class C1914{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int[] b=new int[n];
            for(int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }
            int total=0;
           
            int max=0;
             int ans=0;
            for(int i=0;i<Math.min(n,k);i++){
                ans += a[i];
                max = Math.max(max, b[i]);

                int remainingSteps = k - i - 1;
                int potential = ans + (remainingSteps * max);
                total = Math.max(total, potential);
            }
            System.out.println(total);
        }
    }
}