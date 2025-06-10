import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1849 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[][] a = new long[n][2];
            for(int i = 0; i < n; i++) {
               long val = sc.nextLong();
               a[i][0] = val % k;
               if(a[i][0] == 0) {
                  a[i][0] = k;
               }
               a[i][1] = i+1;
            }
            Arrays.sort(a , (x,y) -> {
               if(x[0] == y[0]){
                  return Long.compare(y[1], x[1]);
               }else{
                  return Long.compare(x[0], y[0]);
               }
            });
            for(int i=n-1;i>=0;i--) {
               System.out.print(a[i][1] + " ");
            }
            System.out.println();  
        }
    }
}
