import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1917{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            sc.nextLine();
            String s=sc.next();
            HashSet<Character>set=new HashSet<>();
            int cnt=0;
	        for(int i=0;i<n;i++){
	            set.add(s.charAt(i));
	            cnt+=set.size();
	        }
	        System.out.println(cnt);
        }
    }
}