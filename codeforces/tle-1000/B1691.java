import java.util.HashMap;
import java.util.Scanner;

public class B1691 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long arr[]=new long[n];
            HashMap<Long,Integer>map=new HashMap<>();
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
            boolean flag=false;
            for(int val:map.values()){
                if(val<=1){
                    System.out.println(-1);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                int l=0;
                int r=0;
                while(r<n){
                    if(arr[r]!=arr[l]){
                        fun(arr,l,r-1);
                        l=r;
                    }
                    r++;
                    
                    
                }
                fun(arr,l,r-1);
                for(int i=0;i<n;i++){
	                System.out.print(arr[i]+" ");
                }
                System.out.println();
            }
            
        }
        
    }
    public static void fun(long arr[], int l, int r) {
    arr[l] = r+1;
    for (int i = l + 1; i <= r; i++) {
        arr[i] = i ;
    }
}

}
