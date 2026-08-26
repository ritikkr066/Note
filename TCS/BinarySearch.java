import java.util.Scanner;

public class BinarySearch {

    public static int findTarget(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                ans=mid;
                return ans;
            }else if(arr[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    public static int firstOccurence(int[] arr,int target){
        int left=0;
        int right=arr.length;

        while(left<right){
            int mid=left+(right-left)/2;
            if(target<=arr[mid]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
     public static int lastOccurence(int[] arr,int target){
        int left=0;
        int right=arr.length;

        while(left<right){
            int mid=left+(right-left)/2;
            if(target>=arr[mid]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left-1;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();

        int ans=findTarget(arr,target);
    }
}
