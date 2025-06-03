import java.util.Scanner;

public class B1582 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            long count=0;
            long one1=0;
            for(int i=0;i<n;i++){
                if(arr[i]==0){
                    count++;    
                }else if(arr[i]==1){
                    one1++;
                }   
            }

            System.out.println((long)Math.pow(2.0,count)*one1);
        }
    }
}
