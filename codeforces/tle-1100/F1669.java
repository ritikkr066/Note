import java.util.Scanner;

public class F1669 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            long suffix=0;
            long prefix=0;
            int left=0;
            int right=n-1;
            int ans=0;
            prefix=arr[0];
            suffix=arr[n-1];
            while(left<right){
                if(suffix==prefix){
                    ans=(n-right)+(left+1);
                    left++;
                    right--;
                    if(left!=right){
                        prefix+=arr[left];
                        suffix+=arr[right];
                    }
                }else if(suffix>prefix){
                    left++;
                    if(left<right)prefix+=arr[left];
                }else{
                    right--;
                    if(right>left) suffix+=arr[right];
                }
            }
            System.out.println(ans);
        }
    }
}
