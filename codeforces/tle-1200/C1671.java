import java.util.Arrays;
import java.util.Scanner;

public class C1671{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            long x=sc.nextInt();

            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            Arrays.sort(arr);
            long prefixSum[] =new long[n];
            prefixSum[0]=arr[0];
            for(int i=1;i<n;i++){
                prefixSum[i]=prefixSum[i-1]+arr[i];
            }
            long time=0;
            long ans=0;
            for(int i=n-1;i>=0;i--){
                long val=prefixSum[i];
                long count=0;
                if(val<=x){
                    count+=1;
                    count += (x-val)/(i+1);
                    ans += (count*(i+1))-time;
                    time+= count;
                }
            }
            System.out.println(ans);
        }
    }
}