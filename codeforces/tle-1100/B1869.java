import java.util.Scanner;

public class B1869 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();

            long arr[][]=new long[n+1][2];
            for(int i=1;i<=n;i++){
                arr[i][0]=sc.nextLong();
                arr[i][1]=sc.nextLong();
            }

            long min1=Long.MAX_VALUE/2;
            long start[]=arr[a];
            for(int i=1;i<=k;i++){
                long dist=Math.abs(start[0]-arr[i][0])+Math.abs(start[1]-arr[i][1]);
                if(dist<min1){
                    min1=dist;
                }
            }
            long min2=Long.MAX_VALUE/2;
            long end[]=arr[b];
            for(int i=1;i<=k;i++){
                long dist=Math.abs(end[0]-arr[i][0])+Math.abs(end[1]-arr[i][1]);
                if(dist<min2){
                    min2=dist;
                }
            }

            long dist=Math.abs(end[0]-start[0])+Math.abs(end[1]-start[1]);


            if(a<=k && b<=k){
                System.out.println(0);
            }else if(a<=k){
                System.out.println(Math.min(min2,dist));
            }else if(b<=k){
                System.out.println(Math.min(min1,dist));
            }else{
                System.out.println(Math.min(min2+min1,dist));
            }
        }
    }
}
