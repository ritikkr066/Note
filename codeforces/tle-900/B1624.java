import java.util.Scanner;

public class B1624 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder output = new StringBuilder();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            boolean canFormAP = false;
            if ((a + c) % (2 * b) == 0) {
                canFormAP = true;
            }
            else if ((2 * b - a) > 0 && (2 * b - a) % c == 0) {
                canFormAP = true;
            }
            else if ((2 * b - c) > 0 && (2 * b - c) % a == 0) {
                canFormAP = true;
            }
            output.append(canFormAP ? "YES\n" : "NO\n");
        }
        System.out.println(output);
    }
}
