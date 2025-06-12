import java.util.*;

public class B1614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[][] x = new int[n][2]; // x[i][0] = value, x[i][1] = original index

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                x[i][0] = arr[i];
                x[i][1] = i;
            }

            Arrays.sort(x, (a, b) -> Integer.compare(a[0], b[0]));

            int a = 1;
            int b = -1;
            boolean c = true;
            int[] ans = new int[n];

            for (int i = n - 1; i >= 0; i--) {
                int idx = x[i][1]; // original index
                if (c) {
                    ans[idx] = a++;
                } else {
                    ans[idx] = b--;
                }
                c = !c;
            }

            long sum = 0;
            long count = 2;
            for (int i = n - 1; i > 0; i -= 2) {
                sum += (long)(x[i][0] + x[i - 1][0]) * count;
                count += 2;
            }
            if (n % 2 == 1) {
                sum += (long)x[0][0] * count;
            }

            System.out.println(sum);
            System.out.print(0 + " ");
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
