import java.util.Arrays;
import java.util.Scanner;

public class D1850 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long k=sc.nextLong();
            long arr[] =new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            Arrays.sort(arr);
            int count=1;
            int max=1;
            for(int i=1;i<n;i++){
                if(arr[i]-arr[i-1]<=k){
                    count++;
                }else{
                    count=1;
                }
                max=Math.max(max, count);
            }
            System.out.println(n-max);
        }
    }
}
