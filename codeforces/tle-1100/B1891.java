import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B1891 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int q=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int x[]=new int[q];
            for(int i=0;i<q;i++){
                x[i]=sc.nextInt();
               
            }
           
            int min = Integer.MAX_VALUE;
            for(int i=0;i<q;i++){
                if(min>x[i]){
                    min = x[i];
                for(int j=0;j<n;j++){
                    if(a[j]%(int)(Math.pow(2, x[i]))==0){
                        a[j]+=(int)Math.pow(2, x[i]-1);
                    }
                }
            }
            }
            for(int i=0;i<n;i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
    }
}
