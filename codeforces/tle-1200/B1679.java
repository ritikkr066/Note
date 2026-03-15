import java.util.*;

public class B1679 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        long[] value = new long[n];
        int[] lastUpdateTime = new int[n];

        long sum = 0;

        for (int i = 0; i < n; i++) {
            value[i] = sc.nextLong();
            sum += value[i];
        }

        long globalValue = 0;
        int lastGlobalUpdateTime = -1;

        int currentTime = 0;

        while (q-- > 0) {
            currentTime++;

            int t = sc.nextInt();

            if (t == 1) {
                int i = sc.nextInt() - 1;
                long x = sc.nextLong();

                long oldValue;

                if (lastUpdateTime[i] > lastGlobalUpdateTime) {
                    oldValue = value[i];
                } else {
                    oldValue = globalValue;
                }

                sum = sum - oldValue + x;

                value[i] = x;
                lastUpdateTime[i] = currentTime;

            } else {
                long x = sc.nextLong();

                globalValue = x;
                sum = n * x;
                lastGlobalUpdateTime = currentTime;
            }

            System.out.println(sum);
        }

        sc.close();
    }
}