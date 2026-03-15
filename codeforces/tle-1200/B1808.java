import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B1808 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int m=sc.nextInt();

            

            long[][] arr=new long[n][m];

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=sc.nextLong();
                }
            }

            if(n<=1){
                System.out.println(0);
                continue;
            }

            long ans=0;

            for(int i=0;i<m;i++){
                long temp[]=new long[n]; 
                for(int j=0;j<n;j++){
                    temp[j]=arr[j][i];
                }

                Arrays.sort(temp);
                int count=1;
                long prev=0;
                long curr=0;
                for(int k=n-2;k>=0;k--){
                    curr=Math.abs(temp[k]-temp[k+1]);
                    prev += (count*curr);
                    ans += prev;
                    count++;
                }
            }

            System.out.println(ans);
        }
    }
}
