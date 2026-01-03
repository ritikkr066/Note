// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Scanner;

// public class t1092{
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         long num=(long)n*(n+1)/2;
//         if(num%2==1){
//             System.out.println("NO");
//         }else{
//             System.out.println("YES");
//             ArrayList<Integer>list1=new ArrayList<>();
//             ArrayList<Integer>list2=new ArrayList<>();
//             long sum1=0;
//             long sum2=0;
//             while(n>0){
//                 if(sum1<=sum2){
//                     sum1+=n;
//                     list1.add(n);
//                 }else{
//                     sum2+=n;
//                     list2.add(n);
//                 }
//                 n--;
//             }
//             System.out.println(list1.size());
//             Collections.sort(list1);
//             for(int el:list1){
//                 System.out.print(el+" ");
//             }
//             System.out.println();
//             System.out.println(list2.size());
//             Collections.sort(list2);
//             for(int el:list2){
//                 System.out.print(el+" ");
//             }
//         }
//     }
// }


import java.io.*;
import java.util.*;

public class t1092 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long total = (long) n * (n + 1) / 2;
        if (total % 2 != 0) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        long sum1 = 0, sum2 = 0;

        for (int i = n; i >= 1; i--) {
            if (sum1 <= sum2) {
                sum1 += i;
                list1.add(i);
            } else {
                sum2 += i;
                list2.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(list1.size()).append('\n');
        for (int x : list1) sb.append(x).append(' ');
        sb.append('\n');

        sb.append(list2.size()).append('\n');
        for (int x : list2) sb.append(x).append(' ');

        System.out.print(sb.toString());
    }
}
