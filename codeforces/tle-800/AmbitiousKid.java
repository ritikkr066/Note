import java.util.Scanner;

public class AmbitiousKid {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            int abs=Math.abs(x);
            min=Math.min(min,abs);
        }
        System.out.println(min);
    }
}
