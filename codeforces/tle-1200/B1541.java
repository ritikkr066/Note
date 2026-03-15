import java.util.Scanner;

public class B1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int arr[] = new int[n + 1];
            int pos[] = new int[2 * n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
                pos[arr[i]] = i;
            }

            int count = 0;

            for (int i = 1; i <= n; i++) {

                for (int prod = arr[i]; prod <= 2 * n; prod += arr[i]) {

                    int j = prod - i;

                    if (j > i && j <= n) {

                        int aj = prod / arr[i];

                        if (aj <= 2 * n && pos[aj] == j) {
                            count++;
                        }
                    }
                }
            }

            System.out.println(count);
        }

        sc.close();
    }
}