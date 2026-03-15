import java.util.*;

public class C1635 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            boolean sorted = true;
            for (int i = 1; i < n; i++) {
                if (a[i] < a[i - 1]) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                System.out.println(0);
                continue;
            }

            // If last two violate condition → impossible
            if (a[n - 2] > a[n - 1] || a[n - 1] < 0) {
                System.out.println(-1);
                continue;
            }

            // Otherwise solution exists
            System.out.println(n - 2);
            for (int i = 0; i <= n - 3; i++) {
                System.out.println((i + 1) + " " + (n - 1) + " " + n);
            }
        }
        sc.close();
    }
}