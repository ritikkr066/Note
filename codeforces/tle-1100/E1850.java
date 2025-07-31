import java.util.Scanner;

public class E1850 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            long c=sc.nextLong();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            long left=1;
            long right=(long)Math.ceil(Math.sqrt(c/2.0));
            long ans=-1;
            while (left<=right) {
                long mid=left+(right-left)/2;
                if (findWeight(mid,arr,c)){
                    ans=mid;
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
             System.out.println(ans);
        } 
    }

    public static boolean findWeight(long mid,int[] arr,long c){
        long wt=0;
        for(int i=0;i<arr.length;i++){
            wt+=(arr[i]+2*mid)*(arr[i]+2*mid);
            if(wt>c)return false;
        }
        return true;
    }
}
