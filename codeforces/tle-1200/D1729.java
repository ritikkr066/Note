import java.util.Arrays;
import java.util.Scanner;

public class D1729 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int arr1[]=new int[n];
            int arr2[]= new int[n];
            for(int i=0;i<n;i++){
                arr1[i]=sc.nextInt();
            }

            for(int i=0;i<n;i++){
                arr2[i]=sc.nextInt();
            }

            int diff[]=new int[n];
            for(int i=0;i<n;i++){
                diff[i]=arr2[i]-arr1[i];
            }
            Arrays.sort(diff);

            int left=0;
            int right=n-1;
            int ans=0;
            while (left<right) {
               if(diff[left]+diff[right]>=0){
                    ans++;
                    left++;
                    right--;
               }else{
                    left++;
               }
            }
            System.out.println(ans);
        }
    }
}
