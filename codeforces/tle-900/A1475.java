import java.util.Scanner;

public class A1475{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            while (n%2 == 0) {
                n = n/2;
            }
            if(n == 1){
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}

// ---------- TLE------

// import java.util.Scanner;

// public class A1475 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
//         while(t-- > 0){
//             long n = sc.nextLong();

//             if(prime(n)){
//                 System.out.println(n == 2 ? "NO" : "YES");
//             } else {
//                 if((n & (n - 1)) != 0){
//                     System.out.println("YES");
//                 } else {
//                     System.out.println("NO");
//                 }
//             }
//         }
//     }

//     public static boolean prime(long num){
//         if(num <= 1) return false;
//         if(num <= 3) return true;
//         if(num % 2 == 0 || num % 3 == 0) return false;

//         for(long i = 5; i * i <= num; i += 6){
//             if(num % i == 0 || num % (i + 2) == 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }


// ----------TLE-----------------

// import java.util.Scanner;

// public class A1475 {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int t=sc.nextInt();
//         while(t-->0){
//             long n=sc.nextLong();
            
//             if(prime(n)){
//                 if(n==2){
//                     System.out.println("NO");
//                 }else{
//                     System.out.println("YES");
//                 }
//                 continue;
//             }
//             boolean flag=false;
//             while(n>1){
//                 if(n%2==0){
//                     n/=2;
//                 }else{
//                     flag=true;
//                     break;
//                 }
//             }
//              if(flag){
//                 System.out.println("YES");
//              }else{
//                 System.out.println("NO");
//              }
//         }
       
//     }

//     public static boolean prime(long num){
//         if(num==1)return false;
//         if(num<=3) return true;
//         if(num%2==0 || num%3==0)return false;
//         for(long i=5;i*i<=num;i=i+6){
//             if(num%i==0 || num%(i+2)==0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
