import java.util.Scanner;

public class B1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            long maxArea = 0;
            for (int i = 0; i < 4; i++) {
                int k = sc.nextInt();
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for (int j = 0; j < k; j++) {
                    int val = sc.nextInt();
                    min = Math.min(min, val);
                    max = Math.max(max, val);
                }
                if (i < 2) {
                    maxArea = Math.max(maxArea, 1L * (max - min) * h);
                } else {
                    maxArea = Math.max(maxArea, 1L * (max - min) * w);
                }
            }
            System.out.println(maxArea);
        }
    }
}
