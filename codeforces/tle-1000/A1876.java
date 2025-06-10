import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A1876 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int p=sc.nextInt();
            int arr[]=new int[n];
             ArrayList<int[]>list=new ArrayList<>();
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int cost[]=new int[n];
            for(int i=0;i<n;i++){
                cost[i]=sc.nextInt();
                list.add(new int[]{arr[i],cost[i]});
            }
             Collections.sort(list,(a,b)->a[1]-b[1]);
            long ans=0;
            ans+=p;
            int used = 1;
            for (int[] curr : list) {
                int take = Math.min(curr[0], n - used);
                curr[1]=Math.min(curr[1],p);
                ans += 1L * take * curr[1];
                used += take;
                if (used == n) break;
            }
            System.out.println(ans);
        }
    }
}
