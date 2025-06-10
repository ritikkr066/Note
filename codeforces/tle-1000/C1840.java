import java.util.Scanner;

public class C1840 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            long q=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            long ans=0;
            int count=0;
            int less=0;
            for(int i=0;i<n;i++){
                if(arr[i]<=q){
                    count++;
                    less++;
                }else{
                    if(count>=k){
                         ans+=(long)(count-k+1)*(count-k+1+1)/(2);
                    }
                    count=0;
                }
            }
            if(count>=k){
                 ans+=(long)(count-k+1)*(count-k+1+1)/2;
            }
           
            if(less<k){
                System.out.println(0);
            }else{
                System.out.println(ans);
            }
            
        }
    }
}
