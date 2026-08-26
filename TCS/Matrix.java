import java.util.Scanner;

public class Matrix {

    public static int findSecSum(int[][] arr){
        int m=arr.length;
        int sum=0;
        int n=arr[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i+j==m-1){
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }

    public static int findBounSum(int[][] arr){
        int m=arr.length;
        int sum=0;
        int n=arr[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }

    public static int[][] transpose(int[][] arr){
        int m=arr.length;
        int n=arr[0].length;
        int mat[][]=new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[j][i]=arr[i][j];
            }
        }
        return mat;
    }
    public static void transpos2(int[][] arr){
        int m=arr.length;
        int n=arr[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i<j){
                    int temp=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int arr[][] =new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int secSum=findSecSum(arr);
        int boundarySum=findBounSum(arr);
    }
}
