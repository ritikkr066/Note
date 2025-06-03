import java.util.Scanner;

public class Hallauli{
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
            boolean flag=true;
            for(int i=1;i<n;i++){
                if(arr[i]<arr[i-1]){
                    flag=false;
                }
            }
            if(flag || k>1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}