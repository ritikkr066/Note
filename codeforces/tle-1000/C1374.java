import java.util.Scanner;

public class C1374 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            sc.nextLine();
            String s=sc.next();
            int open=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    open++;
                }else {
                    if(open>0)open--;
                }
            }
            System.out.println(open);
        }
    }
}
