import java.util.Scanner;

public class C1899 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int total=arr[0];
            int ans=arr[0];
            int prev=Math.abs(arr[0])%2;
            for(int i=1;i<n;i++){
                if(Math.abs(arr[i])%2==prev){
                    total=Math.max(total,arr[i]);
                    ans=Math.max(total,ans);
                    total=arr[i];
                }else{
                    if(total<0)total=0;
                    total+=arr[i];
                    prev=Math.abs(arr[i])%2;
                    ans=Math.max(total, ans);
                    
                }
            }
            System.out.println(ans);
        }
    }
}
