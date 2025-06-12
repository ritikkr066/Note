import java.util.*;
public class B1567
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	   while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int xor = 0;
            if ((a-1) % 4 == 0)
                xor =  (a-1);
            else if ((a-1) % 4 == 1)
                xor= 1;
            else if ((a-1) % 4 == 2)
                xor =  ((a-1) + 1);
            else if ((a-1) % 4 == 3)
                xor = 0;
 
            if(xor == b){
                System.out.println(a);
            } else {
                if((xor^b) == a){
                    System.out.println(a+2);
                } else {
                    System.out.println(a+1);
                }
            }
        }
	}
}