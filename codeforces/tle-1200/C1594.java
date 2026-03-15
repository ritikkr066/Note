import java.util.*;

public class C1594 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            char c = sc.next().charAt(0);
            String s = sc.next();

            // Step 1: check if already all c
            boolean allC = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != c) {
                    allC = false;
                    break;
                }
            }

            if (allC) {
                System.out.println(0);
                continue;
            }

            // Step 2: if last character is c → 1 operation
            if (s.charAt(n - 1) == c) {
                System.out.println(1);
                System.out.println(n);
                continue;
            }

            // Step 3: try to find x such that all multiples of x are already c
            int goodX = -1;

            for (int x = 1; x <= n; x++) {
                boolean ok = true;
                for (int multiple = x; multiple <= n; multiple += x) {
                    if (s.charAt(multiple - 1) != c) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    goodX = x;
                    break;
                }
            }

            if (goodX != -1) {
                System.out.println(1);
                System.out.println(goodX);
            } else {
                // Step 4: always possible in 2 operations
                System.out.println(2);
                System.out.println(n + " " + (n - 1));
            }
        }

        sc.close();
    }
}