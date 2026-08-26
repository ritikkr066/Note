import java.util.Scanner;
import java.util.Stack;

public class nextGreater {

    public static int[] greaterElement(int[] arr){
        int len=arr.length;
        int ans[]=new int[len];

        for(int i=0;i<len;i++){
            ans[i]=-1;
            for(int j=i+1;j<len;j++){
                if(arr[j]>arr[i]){
                    ans[i]=arr[j];
                    break;
                }
            }
        }
        return ans;  
    }

    public static int[] nextGreater2(int[] arr){
        int ans[]= new int[arr.length];
        Stack<Integer>st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }

            if(!st.isEmpty())ans[i]=st.peek();
            else ans[i]=-1;
            
            st.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int ans[]=new int[n];
        ans=nextGreater2(arr);
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
