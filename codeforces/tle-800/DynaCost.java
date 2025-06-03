import java.util.Scanner;

public class DynaCost {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            boolean flag=false;
            for(int i=0;i<n;i++){
                if(arr[i]==k){
                    flag=true;
                }
            }
            if(flag){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
