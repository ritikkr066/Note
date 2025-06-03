import java.util.Scanner;

public class DontryToCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            sc.nextLine();
            String str=sc.next();
            String str2=sc.next();

            int count=0;
            while(count<=10 && (!str.contains(str2))){
                count++;
                str+=str;
            }
            if(count>10){
                System.out.println(-1);
                continue;
            }
            System.out.println(count);
        }
    }
}
