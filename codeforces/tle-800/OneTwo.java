import java.util.Scanner;

public class OneTwo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int count=0;
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                if(arr[i]==2)count++;
            }
            if(count==0){
                System.out.println(1);
            }
            else if(count%2==1){
                System.out.println(-1);
            }else{
                int cnt=0;
                for(int i=0;i<n;i++){
                   if(arr[i]==2)cnt++;
                    if(cnt==count/2){
                        System.out.println(i+1);
                        break;
                    }
                }
            }
        }
    }
}
