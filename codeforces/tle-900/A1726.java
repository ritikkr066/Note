import java.util.Scanner;

public class A1726 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n+1];
            for(int i=1;i<=n;i++){
                arr[i]=sc.nextInt();
            }
            int maxi = arr[n] - arr[1];
 
        // Fix arr[n]
        for (int i = 1; i <= n - 1; i++) {
            maxi = Math.max(maxi, arr[n] - arr[i]);
        }
 
        // Fix arr[1]
        for (int i = 2; i <= n; i++) {
            maxi = Math.max(maxi, arr[i] - arr[1]);
        }
 
        // Pick entire array as a sub-segment
        for (int i = 1; i <= n - 1; i++) {
            maxi = Math.max(maxi, arr[i] - arr[i + 1]);
        }
 
        System.out.println(maxi);
        }
    }
}
