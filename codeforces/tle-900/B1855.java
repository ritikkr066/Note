import java.util.Scanner;

public class B1855 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextLong();
            int i=1;
            while (n%(i+1)==0) {
                i++;
            }
            System.out.println(i);
        }
    }
}
