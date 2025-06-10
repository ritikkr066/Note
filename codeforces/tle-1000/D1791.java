import java.util.HashSet;
import java.util.Scanner;

public class D1791 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            sc.nextLine();
            String s=sc.next();
            int prefix[]=new int[n];
            int suffix[]=new int[n];
            HashSet<Integer>pre=new HashSet<>();
            for(int i=0;i<n;i++){
                pre.add(s.charAt(i)-'a');
                prefix[i]=pre.size();
            }

            HashSet<Integer>suf=new HashSet<>();
            for(int i=n-1;i>=0;i--){
                suf.add(s.charAt(i)-'a');
                suffix[i]=suf.size();
            }
            
            int max=0;
            for(int i=0;i<n-1;i++){
                max=Math.max(max,prefix[i]+suffix[i+1]);
            }
           
            System.out.println(max);
        }
    }
}
