import java.util.Scanner;

public class c1744 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            // sc.nextLine();
            char ch=sc.next().charAt(0);
            String s=sc.next(); 
            // s+=s;
            StringBuilder sb=new StringBuilder(s);
            sb.append(s);
            int idx=-1;
            int max=0;
            for(int i=0;i<sb.length();i++){
                if(idx==-1 && sb.charAt(i)==ch){
                    idx=i;
                }
                if(idx>-1 && sb.charAt(i)=='g'){
                    max=Math.max(max,i-idx);
                    idx=-1;
                }
            }
            if(ch=='g'){
                System.out.println(0);
            }else{
                System.out.println(max);
            }
        }
    }
}
