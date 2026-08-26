import java.util.Scanner;

public class B1527 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            String str=sc.next();
            // sc.next();
            int zero=0;
            for(int i=0;i<n;i++){
                if(str.charAt(i)=='0')zero++;
            }
            if(zero==0){
                System.out.println("DRAW");
                continue;
            }
            if(zero==1){
                System.out.println("BOB");
                continue;
            }
            System.out.println(zero%2==0 ? "BOB" : "ALICE");
        }
    }

}
