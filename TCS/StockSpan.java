import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

    public static int[] findStockSpan(int[] arr){
        Stack<Integer>st=new Stack<>();
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(!st.isEmpty())ans[i]=i-st.peek();
            else ans[i]=1;
            st.push(i);
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int ans[]=findStockSpan(arr);
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
