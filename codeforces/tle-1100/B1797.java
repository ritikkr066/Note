import java.util.Scanner;

public class B1797 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int l=0;
            int r=n-1;
            long count=0;
            while(l<r){
                for(int i=0;i<n;i++){
                    if(arr[l][i]!=arr[r][n-i-1])count++;
                }
                l++;
                r--;
            }
            if(n%2==1){
                int i=0;
                int j=n-1;
                int p=n/2;
                while(i<j){
                    if(arr[p][i]!=arr[p][j])count++;
                    i++;
                    j--;
                }
                if(count<=k){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }

            } 
             else if(count<=k && (k - count) % 2 == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
