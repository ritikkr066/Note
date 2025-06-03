import java.util.Scanner;

public class A1606 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
           int n=s.length();
           if(n==1){
            System.out.println(s);
                continue;
           }
           else if(n==2){
                if(s.equals("aa") || s.equals("bb")) {
                    System.out.println(s);
                }
                else System.out.println("aa");
                continue;
           }
           int ab=0;
           int ba=0;
            for(int i=1;i<n;i++){
                if(s.charAt(i)=='b' && s.charAt(i-1)=='a'){
                    ab++;
                }
                else if(s.charAt(i)=='a' && s.charAt(i-1)=='b'){
                    ba++;
                }
            }
            StringBuilder sb=new StringBuilder();
            if (ab == ba) {
                sb.append(s);
            } 
            else {
                if (ab > ba) {
                    sb.append("b" + s.substring(1));
                } 
                else {
                    sb.append("a" + s.substring(1));
                }
            }
            System.out.println(sb.toString());

            // int count=0;
            // StringBuilder sb=new StringBuilder(s);
            // if(ab>ba){
            //     count=ab-ba;
            //     for(int i=0;i<n-2;i++){
            //         if(sb.charAt(i)=='a'){
            //              if(!sb.substring(i, i+3).equals("aba")){
            //                 sb.setCharAt(i, 'b');
            //                 count--;
            //              }
            //              if(count==0)break;
            //         }  
            //     }
            // }else if(ba>ab){
            //     count=ba-ab;
            //     for(int i=0;i<n-2;i++){
            //         if(sb.charAt(i)=='b'){
            //              if(!sb.substring(i, i+3).equals("bab")){
            //                 sb.setCharAt(i, 'a');
            //                 count--;
            //              }
            //              if(count==0)break;
            //         }  
            //     }
            // }
            // System.out.println(sb.toString());
        }
    }
}
