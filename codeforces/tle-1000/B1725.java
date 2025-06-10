import java.util.Arrays;
import java.util.Scanner;

public class B1725 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long d=sc.nextLong();
        long arr[]=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        Arrays.sort(arr);
         int ans=0;
        while(n>0 && arr[n-1]>d){
            ans++;
            n--;
        }
        int left=0;
        int right=n-1;
        long curr=0;
        int size=0;
        long max=0;
       
        while(left<right){
            if(curr==0){
                curr=arr[left]+arr[right];
                size=2;
                max=arr[right];
            }else{
                curr+=arr[left];
                size++;
            }
            if(max*size>d){
                ans++;
                curr=0;
                left++;
                right--;
            }else{
                left++;
            }
            
        }
        System.out.println(ans);
    }
}
