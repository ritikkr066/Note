import java.util.Scanner;

public class E1873 {

    public static boolean countWater(long mid,long arr[],long target){
        long count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<mid){
                count+=(mid-arr[i]);
            }
        }
        return count <= target;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            long x=sc.nextLong();

            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            long ans=-1;
            long left=0;
            long right=10000000000L;
            while(left<=right){
                long mid= (left+right)/2;
                if(countWater(mid,arr,x)){
                    ans=mid;
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            System.out.println(ans);
        }
    }
}
