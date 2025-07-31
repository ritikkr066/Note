import java.util.Scanner;

public class B1731 {

    static final long MOD = 1_000_000_007;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
 
        while (t-- > 0) {
            long n = sc.nextLong();
           
            // Step-by-step modulo operations to avoid overflow
            long part1 = (n * (n + 1)) % MOD;            // (n * (n + 1)) % MOD
            long part2 = ((4 * n - 1) % MOD);            // (4n - 1) % MOD
            long result = (((part1 * part2) % MOD) * 337) % MOD;
 
            System.out.println(result);
        }
    }
}
