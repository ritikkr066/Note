import java.util.Scanner;
 
public class A1485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       
        int t = sc.nextInt();  
        
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long ans = Long.MAX_VALUE;
            
            for (long i = 0; i * i <= a; i++) {
               
                if (b == 1 && i == 0) continue;
                
                long count = i;
                long c = a;
                
                while (c > 0) {
                    c /= (b + i);
                    count++;
                }
                
                ans = Math.min(ans, count);
            }
            
           
            System.out.println(ans);
        }
        
        sc.close();
    }
}