import java.util.*;

public class C1857 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();

            int m = n * (n - 1) / 2;
            long[] b = new long[m];

            for (int i = 0; i < m; i++) {
                b[i] = sc.nextLong();
            }

            Arrays.sort(b);

            List<Long> a = new ArrayList<>();
            int idx = 0;

            for (int i = n - 1; i > 0; i--) {
                a.add(b[idx]);
                idx += i;
            }

            a.add((long)1e9);

            for (long val : a) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        
    }
}
