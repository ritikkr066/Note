import java.util.ArrayList;
import java.util.Scanner;

public class oa1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<int[]>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                list.add(new int[]{i,arr[i]});
            }  
        }
        for(int i=1;i<list.size();i++){
            if(Math.abs(list.get(i-1)[1])> Math.abs(list.get(i)[1])){
                for(int j=list.get(i-1)[0]+1;j<list.get(i)[0];j++){
                    arr[j]=list.get(i-1)[1];
                }
            }else{
                for(int j=list.get(i-1)[0]+1;j<list.get(i)[0];j++){
                    arr[j]= list.get(i)[1];
                }
            }
        }
        for(int i=0;i<list.get(0)[0];i++){
            arr[i]= list.get(0)[1];
        }
        for(int i=list.get(list.size()-1)[0]+1;i<n;i++){
            arr[i] = list.get(list.size()-1)[1];
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}