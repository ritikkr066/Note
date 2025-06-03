import java.util.Scanner;

public class B1537{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long m,n,a,b;
            n=sc.nextLong();
            m=sc.nextLong();
           
            a=sc.nextLong();
            b=sc.nextLong();

            long dis=0;
            int idx1=0;
            int idx2=0;
            long corner[][]=new long[][]{{1,1},{1,m},{n,1},{n,m}};
            for(int i=0;i<4;i++){
                long curr=+(Math.abs(a-corner[i][0])+Math.abs(b-corner[i][1]));
                for(int j=0;j<4;j++){
                    long currDist=curr+Math.abs(corner[i][0]-corner[j][0])+Math.abs(corner[i][1]-corner[j][1]);
                    if(currDist>dis){
                        dis=currDist;
                        idx1=i;
                        idx2=j;
                    }
                }
            }
            System.out.println(corner[idx1][0]+" "+corner[idx1][1]+" "+corner[idx2][0]+" "+corner[idx2][1]);
        }
    }
}