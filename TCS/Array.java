import java.util.Scanner;

public class Array {

    public static int findSecLargest(int[] arr){
        int max=Integer.MIN_VALUE;
        int maxSecond=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                maxSecond=max;
                max=arr[i];
               
            }else if(arr[i]<max && arr[i]>maxSecond){
                maxSecond=arr[i];
            }
        }
        return maxSecond;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int arr[]=new int[t];
        for(int i=0;i<t;i++){
            arr[i]=sc.nextInt();
        }

        int seclargest=findSecLargest(arr);
    }
}
