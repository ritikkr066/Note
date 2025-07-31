import java.util.PriorityQueue;
import java.util.Scanner;

public class E1791 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            int negativeCount = 0;
            long sum = 0;
            long minAbs = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                if (a[i] < 0) negativeCount++;
                long absVal = Math.abs(a[i]);
                sum += absVal;
                minAbs = Math.min(minAbs, absVal);
            }

            if (negativeCount % 2 == 0) {
                System.out.println(sum);
            } else {
                System.out.println(sum - 2 * minAbs);
            }
        }
    }
}
