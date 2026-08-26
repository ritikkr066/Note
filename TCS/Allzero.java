import java.util.ArrayList;
import java.util.Scanner;

public class Allzero {

    public static void moveAllZeroAtEnd(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(right>=0){
            if(arr[right]==0){
                right--;
            }else{
                break;
            }
        }
        while(left<right){
            if(arr[left]==0){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                right--;
            }
            left++;
        }
    }
    public static void leftRotateByOne(int[] arr){
        int temp=arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=temp;
    }
    public static int removeDuplicates(int[] arr){
        ArrayList<Integer>list=new ArrayList<>();
        list.add(arr[0]);
        // int count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                // count++;
                list.add(arr[i]);
            }
        }
        // return count;
        return list.size();
    }
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        moveAllZeroAtEnd(arr);
    }
}
