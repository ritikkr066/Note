import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Forked{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int k1=sc.nextInt();
            int k2=sc.nextInt();
            int q1=sc.nextInt();
            int q2=sc.nextInt();

            int dir[][]=new int[][]{{a,b},{-a,-b},{a,-b},{-a,b},{b,a},{-b,-a},{-b,a},{b,-a}};
            HashSet<String>set=new HashSet<>();
            ArrayList<String>list=new ArrayList<>();
            for(int d[]: dir){
                    set.add((k1+d[0])+","+(k2+d[1]));
                    list.add((q1+d[0])+","+(q2+d[1]));
            }
            int count=0;
            for(int i=0;i<list.size();i++){
                if(set.contains(list.get(i))){
                    count++;
                    set.remove(list.get(i));
                }
            }
            System.out.println(count);
        }
    }
}