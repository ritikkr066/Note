import java.util.Scanner;

public class E1692 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int s=sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            int left=0;
            int right=0;
            int sum=0;
            int ans=0;
            while(right<n){
                sum+= arr[right];
                while(sum>s){
                    sum-=arr[left];
                    left++;
                }

                ans=Math.max(ans,right-left+1);
                right++;
            }
            if(sum<s){
                System.out.println(-1);
            }else{
                System.out.println(n-ans);
            }
        }
    }
}
