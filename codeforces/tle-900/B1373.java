import java.util.Scanner;

public class B1373 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int one=0;int zero=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    one++;
                }else zero++;
            }
            System.out.println(Math.min(one,zero)%2!=0 ? "DA":"NET");
        }
    }
}
