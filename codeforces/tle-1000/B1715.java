import java.util.Scanner;

public class B1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long b = sc.nextLong();
            long s = sc.nextLong();

            long minRequired = k * b;
            if (s < minRequired || s > minRequired + (k - 1) * n) {
                System.out.println(-1);
                continue;
            }

            long[] ans = new long[n];
            ans[n - 1] = Math.min(s, minRequired + k - 1);
            s -= ans[n - 1];

            for (int i = 0; i < n - 1; i++) {
                long take = Math.min(k - 1, s);
                ans[i] = take;
                s -= take;
            }

            for (long val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
