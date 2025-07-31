import java.util.Arrays;
import java.util.Scanner;

public class B1832 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int arr[]=new int[n];
            long sum=0;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                sum+=arr[i];
            }
            Arrays.sort(arr);
            int minArr[]=new int[k];
            long minSum=0;
            int j=0;
            for(int i=0;i<k*2;i=i+2){
                minArr[j]=arr[i]+arr[i+1];
                minSum+=minArr[j];
                j++;
            }
            j=0;
            long maxSum=0;
            int[] maxArr=new int[k];
            for(int i=n-1;i>=n-k;i--){
                maxArr[j]=arr[i];
                maxSum+=maxArr[j];
                j++;
            }

            long ans=Math.min(maxSum, minSum);
            for(int i=0;i<k;i++){
                maxSum=maxSum+minArr[i]-maxArr[k-i-1];
                ans=Math.min(ans,maxSum);
            }
            System.out.println(sum-ans);
        }
    }
}
