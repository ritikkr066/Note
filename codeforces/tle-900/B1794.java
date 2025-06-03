import java.util.Scanner;

public class B1794 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
           for(int i=0;i<n;i++){
                arr[i]+=1;
           }
            for(int i=1;i<n;i++){
                if(arr[i]%arr[i-1]==0){
                    arr[i]+=1;
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
