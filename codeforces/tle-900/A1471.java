import java.util.Scanner;

public class A1471{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long x=sc.nextLong();
            long arr[]=new long[n];
            long sum=0;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
                sum+=arr[i];
            }
            long max=0;
            for(int i=0;i<n;i++){
                max+=(arr[i]+x-1)/x;
            }
           long  min=(sum+x-1)/x;
           System.out.println(min+" "+max);
        }
    }
}