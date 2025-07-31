import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B1637 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            String s=sc.next();
             Set<Character> diff = new HashSet<>();
        
            for (char c : s.toCharArray()) {
                diff.add(c);
            }
            
            boolean ok = true;
            int n = s.length();
            int dSize = diff.size();
            
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != s.charAt(i % dSize)) {
                    ok = false;
                    break;
                }
            }
            
            System.out.println(ok ? "YES" : "NO");
        }
    }
}
