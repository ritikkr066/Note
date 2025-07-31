import java.util.Scanner;

public class B1820 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            String str=sc.next();
            StringBuilder sb=new StringBuilder(str);
            sb.append(str);
            int local=0;
            int max=0;
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)=='1'){
                    local++;
                }else{
                    local=0;
                }
                max=Math.max(max,local);
            }

            if(max>=str.length()){
                int n=str.length();
                System.out.println((long)n*n);
                continue;
            }else if(max==0 || max==1){
                System.out.println(max);
            }else{
                long sideA = (max + 1) / 2;
                long sideB = (max + 2) / 2;
                System.out.println(sideA * sideB);
            }
            
           
        }
    }
}
