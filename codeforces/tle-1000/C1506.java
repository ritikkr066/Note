import java.util.Scanner;

public class C1506 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            int min=Math.min(a.length(),b.length());
            int len=0;
            for(int i=0;i<=min;i++){
                for(int j=0;j<=a.length();j++){
                    if(j+i<=a.length() && b.contains(a.substring(j,j+i))){
                        if(a.substring(j,j+i).length()>len){
                             len=a.substring(j,j+i).length();
                        }   
                    }
                }
            }
            System.out.println(a.length()+b.length()-2*len);
        }
    }
}
