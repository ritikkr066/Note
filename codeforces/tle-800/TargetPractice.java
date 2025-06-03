import java.util.Scanner;

public class TargetPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        sc.nextLine();
        while (t-- > 0) {
            char str[][] = new char[10][10];
            for (int i = 0; i < 10; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < 10; j++) {
                    str[i][j] = line.charAt(j);
                }
            }
 
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if ((i == 0 || i == 9 || j == 0 || j == 9) && str[i][j] == ('X')) {
                        sum += 1;
                    } else if ((i == 1 || i == 8 || j == 1 || j == 8) && (str[i][j] == ('X'))) {
                        sum += 2;
                    } else if ((i == 2 || i == 7 || j == 2 || j == 7) && (str[i][j] == ('X'))) {
                        sum += 3;
 
                    } else if ((i == 3 || i == 6 || j == 3 || j == 6) && (str[i][j] == ('X'))) {
                        sum += 4;
                    } else if ((i == 4 || i == 5 || j == 4 || j == 5) && (str[i][j] == ('X'))) {
                        sum += 5;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
