import java.util.*;

public class C1832 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            if (n == 1) {
                System.out.println(1);
                sc.nextInt();
                continue;
            }

            List<Long> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                if (arr.isEmpty() || arr.get(arr.size() - 1) != x) {
                    arr.add(x);
                }
            }

            if (arr.size() == 1) {
                System.out.println(1);
                continue;
            }

            int m = arr.size();
            int count = 2; // first and last

            for (int i = 1; i < m - 1; i++) {
                long prev = arr.get(i - 1);
                long curr = arr.get(i);
                long next = arr.get(i + 1);

                if ((curr > prev && curr > next) ||
                    (curr < prev && curr < next)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
