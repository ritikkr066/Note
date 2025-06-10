import java.util.Scanner;

public class B1913{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int n=s.length();
            int one=0;
            int zero=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='1')one++;
                else zero++;
            }
            int idx=n;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='1'){
                    zero--;
                    if(zero<0){
                        idx=i;
                        break;
                    }
                }else {
                    one--;
                    if(one<0){
                        idx=i;
                        break;
                    }
                }
            }
            System.out.println(n-idx);
        }
    }
}