import java.util.HashMap;
import java.util.Scanner;

public class B1665 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            } 
            HashMap<Long,Integer>map=new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
            }
            long max=0;
            for(long el:map.values()){
                max=Math.max(max,el);
            }
            int ans=0;
            ans+=n-max;
            while(max<n){
                max*=2;
                ans++;
            }
            System.out.println(ans);
        }
    }
}
