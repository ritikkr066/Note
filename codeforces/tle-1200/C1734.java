import java.util.*;

public class C1734{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); 
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();   
            
            boolean[] keep = new boolean[n + 1];
            boolean[] deleted = new boolean[n + 1];
            
            // mark which numbers we must keep
            for (int i = 1; i <= n; i++) {
                keep[i] = (s.charAt(i - 1) == '1');
            }
            
            long totalCost = 0;
            
            for (int k = 1; k <= n; k++) {
                
                for (int multiple = k; multiple <= n; multiple += k) {
                    
                    // if number is in T (must keep), stop using this k
                    if (keep[multiple]) {
                        break;
                    }
                    
                    // if not deleted yet, delete it
                    if (!deleted[multiple]) {
                        totalCost += k;
                        deleted[multiple] = true;
                    }
                }
            }
            
            System.out.println(totalCost);
        }
        
    }
}