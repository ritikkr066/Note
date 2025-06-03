import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UnitedState {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            ArrayList<Long>list=new ArrayList<>();
            list.add(arr[n-1]);
            int x=n-2;
            while(x>=0 && arr[n-1]==arr[x]){
                list.add(0,arr[n-1]);
                x--;
            }
            int size=list.size();
            if(size==n){
                System.out.println(-1);
            }else{
                System.out.println((n-size)+" "+size);
                for(int i=0;i<n-size;i++){
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
                for(int i=0;i<list.size();i++){
                    System.out.print(list.get(i)+" ");
                }
                System.out.println();
            }
        }
    }
}
