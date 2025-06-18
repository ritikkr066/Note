import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B1904 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            long arr[]=new long[n];
            long sorted[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
                sorted[i]=arr[i];
            }
            Arrays.sort(sorted);
            long prefixsum[]=new long[n];
            prefixsum[0]=sorted[0];
            for(int i=1;i<n;i++){
                prefixsum[i]=prefixsum[i-1]+sorted[i];
            }
            Map<Long,Integer>map=new HashMap<>();
            map.put(sorted[n-1],n-1);
            for(int i=n-2;i>=0;i--){
                if(prefixsum[i]>=sorted[i+1]){
                    map.put(sorted[i],map.get(sorted[i+1]));
                }else{
                    map.put(sorted[i],i);
                }
            }
    
            for(int i=0;i<n;i++){
                System.out.print(map.get(arr[i])+" ");
            }
            System.out.println();
        }
    }
}
