import java.util.Scanner;

public class B1780 {
    public static long gcd(long a,long b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long [] arr = new long[n];
            long sm = 0;
            for(int i =0;i<n;i++){
                arr[i] = sc.nextInt();
                sm +=arr[i];
            }
            long s = 0;
            long mx = 1;
            for(int i =0;i<n-1;i++){
                s+= arr[i];
                long g = gcd(s,sm-s);
                mx = Math.max(mx,g);
            }
            System.out.println(mx);
        }
 
    }
}
