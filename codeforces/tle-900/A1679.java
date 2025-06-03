import java.util.Scanner;

public class A1679 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long min = Long.MAX_VALUE;
            long max = 0;

            if (n % 2 != 0 || n < 4) {
                System.out.println(-1);
                continue;
            }

            if (n % 4 == 0 && n % 6 == 0) {
                max = n / 4;
                min = n / 6;
            }
            else if (n % 4 == 0) {
                max = n / 4;
                long temp = n;
                long count = 0;
                while (temp > 0) {
                    temp -= 4;
                    count++;
                    if (temp % 6 == 0) {
                        min = count + (temp / 6);
                        break;
                    }
                }
            }
            else if (n % 6 == 0) {
                min = n / 6;
                long temp = n;
                long count = 0;
                while (temp > 0) {
                    temp -= 6;
                    count++;
                    if (temp % 4 == 0) {
                        max = count + (temp / 4);
                        break;
                    }
                }
            }
            else {
                long temp = n;
                long minCount = 0;
                while (temp > 0) {
                    temp -= 4;
                    minCount++;
                    if (temp % 6 == 0) {
                        min = minCount + (temp / 6);
                        break;
                    }
                }

                temp = n;
                long maxCount = 0;
                while (temp > 0) {
                    temp -= 6;
                    maxCount++;
                    if (temp % 4 == 0) {
                        max = maxCount + (temp / 4);
                        break;
                    }
                }
            }

            if (min == Long.MAX_VALUE || max == 0) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }

        sc.close();
    }
}
