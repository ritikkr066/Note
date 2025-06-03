import java.util.Scanner;

public class gcdArray {
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
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    int x=gcd(arr[i],arr[j]);
                    if(x==1 || x==2){
                        flag=true;
                        break;
                    }
                }
                if(flag)break;
            }
            if(flag){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
