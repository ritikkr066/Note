import java.util.*;

public class E1703 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  
        
        while (t-- > 0) {
            int n = sc.nextInt();
            char[][] grid = new char[n][n];
            
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next().toCharArray();
            }
            
            int operations = 0;
            
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j<(n + 1) / 2; j++) {
                    
                    char a = grid[i][j];
                    char b = grid[j][n - 1 - i];
                    char c = grid[n - 1 - i][n - 1 - j];
                    char d = grid[n - 1 - j][i];
                    
                    int ones = 0;
                    if (a == '1') ones++;
                    if (b == '1') ones++;
                    if (c == '1') ones++;
                    if (d == '1') ones++;
                    
                    operations += Math.min(ones, 4 - ones);
                }
            }
            
            System.out.println(operations);
        }
    }
}