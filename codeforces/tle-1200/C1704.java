import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class C1704 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int x=sc.nextInt();

            int arr[]=new int[x];
            for(int i=0;i<x;i++){
                arr[i]=sc.nextInt();
            }

            Arrays.sort(arr);
            ArrayList<Integer>diff=new ArrayList<>();
            for(int i=1;i<x;i++){
                diff.add(arr[i]-arr[i-1]-1);
            }  
            diff.add(arr[0]+n-arr[x-1]-1);

            Collections.sort(diff,(a,b)->b-a);

           int days = 0;
            long saved = 0;

            for (int gap : diff) {

                int remaining = gap - 2 * days;

                if (remaining <= 0) continue;

                if (remaining == 1) {
                    saved += 1;
                    days += 1;
                } else {
                    saved += remaining - 1;
                    days += 2;
                }
            }
            System.out.println(n - saved);
        }
    }
}
