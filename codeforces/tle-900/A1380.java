import java.util.Scanner;

public class A1380 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            boolean flag=false;
            int idx=-1;
            for(int i=1;i<n-1;i++){
                if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                    flag=true;
                    idx=i;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
                System.out.println((idx-1+1)+" "+(idx+1)+" "+(idx+1+1));
            }else{
                System.out.println("NO");
            }
        }
    }
}
