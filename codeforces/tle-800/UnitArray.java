import java.util.Scanner;

public class UnitArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int sum=0;
            int mul = 1;
            for(int i=0;i<n;i++){
                int x = sc.nextInt();
                sum += x;
                mul *= x;
            }
            if(sum >= 0){
                System.out.println(mul == 1? 0:1);
            }else{
                int steps = (int) Math.ceil((float)(0-sum)/2);
                mul *= Math.pow(-1,steps);
                sum += steps;
                System.out.println(mul == 1? steps:steps+1);
            }
        }
    }
}
