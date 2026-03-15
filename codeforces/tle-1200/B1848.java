import java.util.*;

public class B1848 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Store positions for each color
            List<List<Integer>> positions = new ArrayList<>();
            for (int i = 0; i <= k; i++) {
                positions.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                positions.get(a[i]).add(i + 1); // 1-based indexing
            }

            int answer = Integer.MAX_VALUE;

            // Try each color
            for (int color = 1; color <= k; color++) {

                List<Integer> pos = positions.get(color);

                int prev = 0;   // boundary before start
                int largest = 0;
                int secondLargest = 0;

                for (int p : pos) {
                    int gap = p - prev - 1;

                    if (gap > largest) {
                        secondLargest = largest;
                        largest = gap;
                    } else if (gap > secondLargest) {
                        secondLargest = gap;
                    }

                    prev = p;
                }

                // gap after last occurrence
                int gap = n - prev;
                if (gap > largest) {
                    secondLargest = largest;
                    largest = gap;
                } else if (gap > secondLargest) {
                    secondLargest = gap;
                }

                int candidate = Math.max(largest / 2, secondLargest);
                answer = Math.min(answer, candidate);
            }

            System.out.println(answer);
        } 
    }
}
