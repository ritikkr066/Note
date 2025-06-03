import java.util.Scanner;

public class Prepend {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            sc.nextLine();
            String binary=sc.next();
            
            int left=0;
            int right=n-1;
            int count=n;
            while(left<right){
                if((binary.charAt(left)=='0' && binary.charAt(right)=='1')||
                    (binary.charAt(left)=='1' && binary.charAt(right)=='0')){
                    left++;
                    right--;
                    count-=2;
                }else{
                    break;
                }
            } 
            System.out.println(count);
        }
    }
}
