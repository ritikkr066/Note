import java.util.Scanner;

public class C1878 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextLong();
            long k=sc.nextLong();
            long x=sc.nextLong();

            long big=(n)*(n+1)/2;
            long small=(n-k)*(n-k+1)/2;
            if(big-small>=x && x>=(k)*(k+1)/2){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
