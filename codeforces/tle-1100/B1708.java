import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class B1708 {

    public static int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int l=sc.nextInt();
            int r=sc.nextInt();
            ArrayList<Integer>list=new ArrayList<>();
            list.add(l);
            for(int i=2;i<=n;i++){
                if(l%i==0){
                    list.add(l);
                }else{
                   int j=l/i;
                   j=(j+1)*i;
                   if(j>r)break;
                   list.add(j);
                }
                if(list.size()==n)break;
            }
            if(list.size()==n){
                System.out.println("YES");
                for(int el:list){
                    System.out.print(el+" ");
                }
                System.out.println();
            }else{
                System.out.println("NO");
            }
        }
    }
}
