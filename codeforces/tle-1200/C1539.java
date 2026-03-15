import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class C1539{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            long k=sc.nextLong();
            long x=sc.nextLong();

            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }

            long diff=0;
            Arrays.sort(arr);
            ArrayList<Long>list=new ArrayList<>();
            for(int i=1;i<n;i++){
                if(arr[i]-arr[i-1]>x)list.add( arr[i] - arr[i-1]);
            }

            if(list.size() == 0){
                System.out.println(1);
                return;
            }

            Collections.sort(list);
            int p=0;
            long d = (list.get(p) - 1) / x;
            while( p<list.size() && k-d>=0 ){
                k-=d;
                p++;
                if(p<list.size()) d = (list.get(p) - 1) / x;
               
            }
            
            System.out.println(list.size()-p+1);
    }
}
