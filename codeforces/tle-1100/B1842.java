import java.util.Scanner;

public class B1842{
    static int ans=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int x=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int b[]=new int[n];
            for(int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }
            int c[]=new int[n];
            for(int i=0;i<n;i++){
                c[i]=sc.nextInt();
            }
            ans = 0;
            if(ans==x){
                System.out.println("YES");
                continue;
            }
            boolean answer=check(a, x);
            if(ans==x){
                System.out.println("YES");
                continue;
            }
            answer=check(b, x);
            if(ans==x){
                System.out.println("YES");
                continue;
            }
            answer=check(c, x);
            System.out.println(ans==x?"YES": "NO");
            
        }
    }

    public static boolean check(int arr[],int x){
        for(int i=0;i<arr.length;i++){
            if(isPossible(arr[i]|ans,x)){
                ans|= arr[i];
                if(ans==x) return true;
            }else{
                return false;
            }    
        }
        return true;
    }
    public static boolean isPossible(int a,int x){
        for(int i=31;i>=0;i--){
            int bitA=(x>>i)&1;
            int bitB=(a>>i)&1;
            if(bitA==0 && bitB==1)return false;
        }
        return true;
    }
}