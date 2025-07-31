import java.util.*;


public class G21807 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);

            if(arr[0]!=1){
                System.out.println("NO");
                continue;
            }
        
            int flag=0;
            
            long prefix=1;
            for(int i=1;i<n;i++){
                if(arr[i]>prefix){
                    flag=1;
                    break;
                }
                prefix+=arr[i];
            }
            
            if(flag==1){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
