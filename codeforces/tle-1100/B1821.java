import java.util.Scanner;

public class B1821 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int arr[]=new int[n+1];
            for(int i=1;i<=n;i++){
                arr[i]=sc.nextInt();
            }
            int copy[]=new int[n+1];
            for(int i=1;i<=n;i++){
                copy[i]=sc.nextInt();
            }

            int l=1;
            int r=n;
            
            for(l=1;l<=n;l++){
                if(copy[l]!=arr[l]){
                    break;
                }
            }
            
            for(r=n;r>=1;r--){
                if(copy[r]!=arr[r])break;
            }

           while(l>1){
                if(copy[l]>=copy[l-1])l--;
                else break;
           }
           while(r<n){
                if(copy[r]<=copy[r+1])r++;
                else break;
           }

            System.out.println(l+" "+r);

        }
    }
}
