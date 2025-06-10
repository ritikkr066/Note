import java.util.Scanner;

public class M1765 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int ans=1;
            for(int i=2;i*i<=n;i++){
                if(n%i==0){
                    ans=n/i;
                    break;
                }
            }
            System.out.println(ans+" "+(n-ans));
            
        }
    }
}
