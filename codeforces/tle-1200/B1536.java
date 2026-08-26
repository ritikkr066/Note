import java.util.*;

public class B1536 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            HashSet<String> set = new HashSet<>();

            for (int len = 1; len <= 3; len++) {

                set.clear();

                for (int i = 0; i + len <= n; i++) {
                    set.add(s.substring(i, i + len));
                }

                boolean found = false;

                if (len == 1) {
                    for (char a = 'a'; a <= 'z'; a++) {
                        String cur = "" + a;
                        if (!set.contains(cur)) {
                            System.out.println(cur);
                            found = true;
                            break;
                        }
                    }
                }

                if (len == 2 && !found) {
                    for (char a = 'a'; a <= 'z'; a++) {
                        for (char b = 'a'; b <= 'z'; b++) {
                            String cur = "" + a + b;
                            if (!set.contains(cur)) {
                                System.out.println(cur);
                                found = true;
                                break;
                            }
                        }
                        if (found) break;
                    }
                }

                if (len == 3 && !found) {
                    for (char a = 'a'; a <= 'z'; a++) {
                        for (char b = 'a'; b <= 'z'; b++) {
                            for (char c = 'a'; c <= 'z'; c++) {
                                String cur = "" + a + b + c;
                                if (!set.contains(cur)) {
                                    System.out.println(cur);
                                    found = true;
                                    break;
                                }
                            }
                            if (found) break;
                        }
                        if (found) break;
                    }
                }

                if (found) break;
            }
        }
    }
}