import java.util.Scanner;

public class GoodArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            int odd=0;
            int even=0;
            int ans=0;
            for(int i=0;i<n;i++){
                if(arr[i]%2==1){
                    if(even>=2){
                        ans+=(even-1);
                    }
                    even=0;
                    odd++;
                }else{
                    if(odd>=2){
                        ans+=(odd-1);
                    }
                    odd=0;
                    even++;
                }
            }
            if(odd>=2){
                ans+=(odd-1);
            }
            if(even>=2){
                ans+=(even-1);
            }
            System.out.println(ans);
        }
    }
}
