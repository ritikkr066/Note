import java.util.ArrayList;
import java.util.Scanner;

public class SequenceGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int m=sc.nextInt();
            long arr[]=new long[m];
            ArrayList<Long>list=new ArrayList<>();
            for(int i=0;i<m;i++){
                arr[i]=sc.nextLong();
                if(i==0){
                    list.add(arr[i]);
                }else if(arr[i-1]>arr[i]){
                    list.add(1L);
                    list.add(arr[i]); 
                }else{
                    list.add(arr[i]);
                } 
            }

            System.out.println(list.size());
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
}
