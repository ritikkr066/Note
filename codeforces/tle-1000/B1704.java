import java.util.Scanner;

public class B1704 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            int ans = 0;
            long min = arr[0];
            long max = arr[0];

            for (int i = 1; i < n; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);

                if (max - min > 2 * x) {
                    ans++;
                    min = arr[i];
                    max = arr[i];
                }
            }

            System.out.println(ans);
        }
    }
}
