import java.util.Scanner;

public class A1155 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s=sc.next();
        int idx=-1;
        boolean flag=false;
        for(int i=1;i<n;i++){
            if(s.charAt(i)<s.charAt(i-1)){
                idx=i;
                flag=true;
                break;
            }
        }
        if(flag){
            System.out.println("YES");
            System.out.println(idx+" "+(idx+1));
        }else{
            System.out.println("NO");
        }
    }
}
