import java.util.HashSet;
import java.util.Scanner;

public class B1656 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
	        int n=sc.nextInt();
	        int k=sc.nextInt();
	       HashSet<Integer> set=new HashSet<>();
	        for(int i=0;i<n;i++){
	           set.add(sc.nextInt());
	        }
	        int f=0;
	        for(int i:set){
	            if(set.contains(i+k)){
	                f=1;
	                break;
	            }
	        }
	        if(f==1){
	            System.out.println("YES");
	        }else{
	            System.out.println("NO");
	        }
	        
	    }
    }
}
