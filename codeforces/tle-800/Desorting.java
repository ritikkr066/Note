import java.util.Scanner;

public class Desorting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            long min=Long.MAX_VALUE;
            for(int i=1;i<n;i++){
                min=Math.min(min,arr[i]-arr[i-1]);
            }
            long x=(long)Math.ceil((min+1)/2.0);
            if(x<=0){
                System.out.println(0);
            }else{
                System.out.println(x);
            }
        }
        
    }
}
