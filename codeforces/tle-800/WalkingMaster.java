import java.util.Scanner;

public class WalkingMaster {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long a=sc.nextLong();
            long b=sc.nextLong();
            long c=sc.nextLong();
            long d=sc.nextLong();
            
            if(c-d >a-b || d <b){
	            System.out.println(-1);
	        }else{
	            long val=(d-c)-(b-a);
	            val+=d-b;
	            System.out.println(val);
	        }
        }
    }
}
