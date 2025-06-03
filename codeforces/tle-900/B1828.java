// import java.util.Scanner;

// public class B1828 {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int t=sc.nextInt();
//         while(t-->0){
//             int n=sc.nextInt();
//             int[] arr=new int[n];
//             for(int i=0;i<n;i++){
//                 arr[i]=sc.nextInt();
//             }
//             int min=Integer.MAX_VALUE;
//             for(int i=0;i<n;i++){
//                 if(arr[i]==i+1)continue;
//                 int x=Math.abs(arr[i]-(i+1));
//                 min=Math.min(min,x);
//             }
//             System.out.println(min);
//         }
//     }
// }

import java.util.Scanner;

public class B1828 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] != i + 1) {
                    int diff = Math.abs(arr[i] - (i + 1));
                    result = gcd(result, diff);
                }
            }

            System.out.println(result);
        }
    }
}

