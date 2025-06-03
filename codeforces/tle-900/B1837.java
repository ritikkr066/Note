import java.util.Scanner;

public class B1837 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            sc.nextLine();
            String str=sc.next();
            int great=0;
            int less=0;
            int max=0;
            for(int i=0;i<n;i++){
                if(str.charAt(i)=='>'){
                    great++;
                    less=0;
                }else{
                    less++;
                    great=0;
                }
                max=Math.max(max,Math.max(great,less));
            }

            System.out.println(max+1);
        }
    }
}
