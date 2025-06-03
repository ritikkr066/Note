import java.util.Scanner;

public class CoverWater {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            sc.nextLine();
            String str=sc.next();
            
            boolean flag=false;
            int count=0;
            int localCount=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='.'){
                    count++;
                    localCount++;
                    if(count==3){
                        flag=true;
                        break;
                    }
                }else{
                    count=0;
                }
            }
            if(flag){
                System.out.println(2);
            }else{
                System.out.println(localCount);
            }
        }
    }
}
