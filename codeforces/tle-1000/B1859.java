import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B1859 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            ArrayList<Integer>min1=new ArrayList<>();
            ArrayList<Integer>min2=new ArrayList<>();
            for(int i=0;i<n;i++){
                int m=sc.nextInt();
                int a[]=new int[m];
                for(int j=0;j<m;j++){
                    a[j]=sc.nextInt();
                }
                Arrays.sort(a);
                min1.add(a[0]);
                min2.add(a[1]);
            }
            long ans=0;
            Collections.sort(min1);
            Collections.sort(min2);
            ans+=min1.get(0);
            for(int i=1;i<min2.size();i++){
                ans+=min2.get(i);
            }
            System.out.println(ans);
        }
    }
}
