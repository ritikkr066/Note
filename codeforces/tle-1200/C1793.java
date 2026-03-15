import java.util.Scanner;

public class C1793 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            int left=0;
            int right=n-1;
            int min=1;
            int max=n;
            boolean flag=false;
            while(left<=right){
                if(arr[left]==min){
                    min++;
                    left++;
                }else if(arr[left]==max){
                    max--;
                    left++;
                }else if(arr[right]==min){
                    min++;
                    right--;
                }else if(arr[right]==max){
                    max--;
                    right--;
                }else{
                    flag=true;
                    break;
                }
            }
            if(flag){
                System.out.println((left+1)+" "+(right+1));
            }else{
                System.out.println(-1);
            }
        }
    }
}
