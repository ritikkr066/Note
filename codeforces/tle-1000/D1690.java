import java.util.Scanner;

public class D1690 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            sc.nextLine();
            String s=sc.next();
            int count=0;
            for(int i=0;i<k;i++){
                if(s.charAt(i)=='B')count++;
            }
            int max=count;
            int r=k;
            int l=0;
            while(r<n){
                if(s.charAt(l)=='B')count--;
                if(s.charAt(r)=='B')count++;
                max=Math.max(max,count);
                l++;
                r++;
            }
            if(max>=k){
                System.out.println(0);
            }else{
                System.out.println(k-max);
            }
        }
    }
}
