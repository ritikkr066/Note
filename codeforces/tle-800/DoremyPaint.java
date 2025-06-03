import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class DoremyPaint {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            HashMap<Integer,Integer>map=new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
            if(map.size()>2){
                System.out.println("No");
            }
            else if (map.size()==1){
                 System.out.println("Yes");
            }else{
                int ans[]=new int[2];
                int i=0;
                for(Integer x: map.values()){
                    ans[i++]=x;
                }
                int min=Math.abs(ans[1]-ans[0]);
                if(min<=1){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
            
        }
    }
}
