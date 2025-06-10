import java.util.HashMap;
import java.util.Scanner;

public class B1831 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int b[]=new int[n];
            for(int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }
            int count=1;
            HashMap<Integer,Integer>map1=new HashMap<>();
            map1.put(a[0],1);
            for(int i=1;i<n;i++){
                if(a[i]==a[i-1]){
                    count++;
                }else{
                    count=1;
                }
                if(map1.get(a[i])==null){
                    map1.put(a[i],1);
                }else{
                    int x=map1.get(a[i]);
                    if(x<count){
                        x=count;
                        map1.put(a[i],x);
                    }
                }
            }
            int max=1;
            int count2=1;
            HashMap<Integer,Integer>map2=new HashMap<>();
            map2.put(b[0],1);
            int v=map1.get(b[0])==null?0:map1.get(b[0]);
            max=Math.max(max,map2.get(b[0])+v);
            for(int i=1;i<n;i++){
                if(b[i]==b[i-1]){
                    count2++;
                }else{
                    count2=1;
                }
                if(map2.get(b[i])==null){
                    map2.put(b[i],1);
                }else{
                    int x=map2.get(b[i]);
                    if(x<count2){
                        x=count2;
                        map2.put(b[i],x);
                    }
                }
                int l=map1.get(b[i])==null?0:map1.get(b[i]);
                max=Math.max(max,map2.get(b[i])+l);
            }
            
            for(int el:map1.values()){
                max=Math.max(max,el);
            }
            System.out.println(max);
        }

    }

}
