import java.util.Scanner;

public class ExtremelyRound {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String str=sc.next();
            int n=str.length();
            int ans=str.charAt(0)-'0';
            ans+=(n-1)*9;
            System.out.println(ans);
        }
    }
}
