import java.util.Scanner;

public class B1675 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            if(n==1){
                System.out.println(0);
                continue;
            }
            int count=0;
            boolean flag=true;
            for(int i=n-2;i>=0;i--){
                if(arr[i]>=arr[i+1]){
                    while(arr[i]>0 && arr[i]>=arr[i+1]){
                        arr[i]/=2;
                        count++;
                    }
                    if(arr[i]>=arr[i+1]){
                        flag=false;
                        break;
                    }
                }
            }
            if(!flag){
                System.out.println(-1);
            }else{
                System.out.println(count);
            }
        }

    }

}
