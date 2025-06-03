import java.util.Scanner;

public class D1807 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int q=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            long q_arr[][]=new long[q][3];
            for(int i=0;i<q;i++){
                for(int j=0;j<3;j++){
                    q_arr[i][j]=sc.nextLong();
                }
            }
            long[] prefixSum=new long[n];
            prefixSum[0]=arr[0];
            for(int i=1;i<n;i++){
                prefixSum[i]=prefixSum[i-1]+arr[i];
            }

           for(int i=0;i<q;i++){
                long l=q_arr[i][0];
                long r=q_arr[i][1];
                long k=q_arr[i][2];

                long sum=0;
                if(l>1){
                    sum+=prefixSum[(int)l-1-1];
                }
                if(r<n){
                    sum+=(prefixSum[n-1]-prefixSum[(int)r-1]);
                }
                sum+=(r-l+1)*k;
                if(sum%2==1){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
           }
        }
    }
}
