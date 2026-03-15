import java.util.Scanner;

public class C1582{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            String str=sc.next();
            sc.nextLine();
            int minSize=Integer.MAX_VALUE;
        
            int left=0;
            int right=n-1;
            boolean flag=true;
            while(left<right){
                if(str.charAt(left)!=str.charAt(right)){
                    flag=false;
                    break;
                }
                left++;
                right--;
            }
            if(flag){
                System.out.println(0);
                continue;
            }

           
            for(char ch= 'a';ch<='z';ch++){
                left=0;
                right=n-1;
                int curr=0;
                flag=true;
                while(left<right){
                    if(str.charAt(left)==str.charAt(right)){
                        left++;
                        right--;
                    }else if(str.charAt(left)==ch){
                        left++;
                        curr++;
                    }else if(str.charAt(right)==ch){
                        right--;
                        curr++;
                    }else{
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    minSize=Math.min(minSize, curr);
            }

            if(minSize==Integer.MAX_VALUE){
                System.out.println(-1);
                continue;
            }

            System.out.println(minSize);
        }

    }
}