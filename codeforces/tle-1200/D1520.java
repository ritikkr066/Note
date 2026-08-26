import java.util.HashMap;
import java.util.Scanner;

public class D1520 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            HashMap<Integer,Integer>map=new HashMap<>();
            long ans=0;
            for(int i=0;i<n;i++){
                int x=arr[i]-i;
                if(map.containsKey(x)){
                    ans+=map.get(x);
                }
                map.put(x,map.getOrDefault(x, 0)+1);
            }
            System.out.println(ans);
        }
    }
}
