import java.util.HashSet;
import java.util.Scanner;

public class TwinPermutation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
	        for(int i=0;i<n;i++){
	           System.out.print(((n+1)-sc.nextInt()) +" ");
	        }
	        System.out.println();
        }
    }
}
