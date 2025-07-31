import java.util.Arrays;
import java.util.Scanner;

public class G11791 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int c=sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=arr[i]+(i+1);
            }
            Arrays.sort(a);
            int count=0;
            for(int i=0;i<n;i++){
                if(a[i]<=c){
                    count++;
                    c-=a[i];
                }else{
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
