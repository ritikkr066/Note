import java.util.*;
 
public class B1440 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
 
            long sum = 0;
            long ans = 0;
 
            long arr[] = new long[n * k];
 
            for (int i = 0; i < n * k; i++) {
                arr[i] = sc.nextLong();
                ans += arr[i];
            }
 
            if (n == 1) {
                System.out.println(ans);
                continue;
            }
 
            if (n == 2) {
                for (int i = 0; i < n * k; i = i + 2 ) {
                    sum += arr[i]; 
                }
                System.out.println(sum);
                continue;
            }
 
            int val = n / 2 + 1;
            int count = 0;
 
            for (int i = n * k - val; i >= 0; i = i - val ) {
                if (count == k) break;
                sum += arr[i];   
                count++;
            }
 
            System.out.println(sum);
        }
        sc.close();
    }
}