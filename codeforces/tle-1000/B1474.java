import java.util.Scanner;

public class B1474 {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;      
        if (n <= 3) return true;       

        if (n % 2 == 0 || n % 3 == 0) return false; 

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int d=sc.nextInt();
            int first=1;
            int second=d+first;
            while(!isPrime(second)){
                second++;
            }

            int third=second+d;
                while(!isPrime(third)){
                    third++;
                }
            System.out.println(second*third);
        }
    }
}
