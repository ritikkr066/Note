import java.util.Arrays;
import java.util.Scanner;

public class C1511 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int query[]=new int[q];
        for(int i=0;i<q;i++){
            query[i]=sc.nextInt();
        }
        int buffer[]=new int[51];
        Arrays.fill(buffer, -1);
        for(int i=0;i<n;i++){
            if(buffer[arr[i]]==-1){
                buffer[arr[i]]=i+1;
            }
        }
        int ans[]=new int[q];
        for(int i=0;i<q;i++){
            int x=query[i];
            int idx=buffer[x];
            ans[i]=idx;
            for(int j=1;j<=50;j++){
                if(buffer[j]<idx){
                    buffer[j]+=1;
                }
            }
            buffer[x]=1;
        }
        for(int i=0;i<q;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}
