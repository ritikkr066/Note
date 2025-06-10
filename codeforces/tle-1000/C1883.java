import java.util.Scanner;

public class C1883 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            boolean flag = false;
            int ans = Integer.MAX_VALUE;

            if (k == 4) {
                int twoCount = 0;
                for (int i = 0; i < n; i++) {
                    int val = arr[i];
                    while (val % 2 == 0) {
                        twoCount++;
                        val /= 2;
                    }
                }
                if (twoCount >= 2) ans = 0;
                else if (twoCount == 1) ans = 1;
                else ans = 2;
            }

            for (int i = 0; i < n; i++) {
                if (arr[i] % k == 0) {
                    flag = true;
                    break;
                } else {
                    ans = Math.min(ans, k - (arr[i] % k));
                }
            }

            if (flag) {
                System.out.println(0);
            } else {
                System.out.println(ans);
            }
        }
    }
}
