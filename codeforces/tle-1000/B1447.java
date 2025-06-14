import java.util.Scanner;

public class B1447 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int arr[][]=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int min=Integer.MAX_VALUE;
            boolean zero=false;
            int sum=0;
            int neg=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]<0)neg++;
                    sum+=Math.abs(arr[i][j]);
                    if(arr[i][j]==0)zero=true;
                    if(arr[i][j]!=0){
                        min=Math.min(Math.abs(arr[i][j]),min);
                    }
                }
            }
            if(zero || neg%2==0){
                System.out.println(sum);
            }else{
                System.out.println(sum-2*min);
            }
        }
    }
}
