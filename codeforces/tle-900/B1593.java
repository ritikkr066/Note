import java.util.Scanner;

public class B1593{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
           String num=sc.next();
            int n=num.length();
            boolean five=false;
            boolean zero =false;
            int ans=0;
           for(int i=n-1;i>=0;i--){
                char ch=num.charAt(i);
                if(!five && ch=='5'){
                    five=true;
                }else if(five && (ch=='2' || ch=='7')){
                    ans=n-1-(i+1);
                    break;
                }
                
                if(!zero && ch=='0'){
                    zero =true;
                }else if(zero && (ch=='5' || ch=='0')){
                    ans=n-1-(i+1);
                    break;
               }
            }
            System.out.println(ans);
        }
    }
}