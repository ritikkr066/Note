import java.util.Scanner;

public class B1632 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            boolean flag=false;
            for(int i=n-1;i>0;i--){
                System.out.print(i+" ");
                if(!flag && (i&(i-1))==0){
                    System.out.print(0+" ");
                    flag=true;
                }
            }
            System.out.println();
        }
    }
}
