import java.util.Scanner;

public class B1696 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            int count=0;
            for(int i=0;i<n;i++){
                if(i>0 && arr[i-1]!=0 && arr[i]==0){
                    count++;
                }
            }
            if(arr[n-1]!=0)count++;
           System.out.println(Math.min(2,count));
        }
    }
}
