import java.util.Scanner;

public class E1742 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int k=sc.nextInt();

            long arr1[]=new long[n];
            for(int i=0;i<n;i++){
                arr1[i]=sc.nextLong();
            }

            long arr2[]=new long[k];
            for(int i=0;i<k;i++){
                arr2[i]=sc.nextLong();
            }

            long prefixSum[]=new long[n];
            prefixSum[0]=arr1[0];
            for(int i=1;i<n;i++){
                prefixSum[i]=prefixSum[i-1]+arr1[i];
            }

            long maxTillNow[]=new long[n];
            long max=-1;
            for(int i=0;i<n;i++){
                max=Math.max(max,arr1[i]);
                maxTillNow[i]=max;
            }

            for(int i=0;i<k;i++){
                int x=findPostion(maxTillNow,arr2[i]);
               if(x == -1){
                    System.out.print(0 + " ");
                } else {
                    System.out.print(prefixSum[x] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int findPostion(long[] maxTillNow,long target){
        int left=0;
        int right=maxTillNow.length-1;
           int ans = -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(maxTillNow[mid]<=target){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
}
