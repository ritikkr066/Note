// import java.util.Arrays;
// import java.util.Scanner;

// public class D1666 {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int T=sc.nextInt();
//         while(T-->0){
//             String s=sc.next();
//             String t=sc.next();
//             int n=t.length();
//             if(n>s.length()){
//                 System.out.println("NO");
//                 continue;
//             }
//             int a[]=new int[26];
//             boolean flag=false;
//             Arrays.fill(a, -2);
           
//             a[t.charAt(n-1)-'A']=s.length()-1;

//             int min=s.lastIndexOf(t.charAt(n-1));
//             if(min==-1){
//                 System.out.println("NO");
//                 continue;
//             }
             
//             for(int i=n-2;i>=0;i--){
//                 char ch=t.charAt(i);
//                 if(a[ch-'A']!=-2){
//                     int last=a[ch-'A'];
//                     // int lastIndex=s.substring(0,last).lastIndexOf(ch);
//                    int lastIndex = s.lastIndexOf(ch, last-1);
//                     if(lastIndex==-1 || lastIndex>min){
//                          flag=true;
//                         break;
//                     }
//                     min=Math.min(min,lastIndex);
//                     a[ch-'A']=lastIndex;
//                 }else{
//                     int lastIndex=s.lastIndexOf(ch);
                   
//                     if(lastIndex ==-1 || lastIndex>min){
//                          flag=true;
//                         break;
//                     }
//                     min=Math.min(min,lastIndex);
//                     a[ch-'A']=lastIndex;
//                 }
//             }
//             if(flag){
//                 System.out.println("NO");
//             }else{
//                 System.out.println("YES");
//             }
//         }
//     }
// }


import java.util.Scanner;

public class D1666 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            String t = sc.next();

            int i = s.length() - 1;
            int j = t.length() - 1;

            // Match t from the back of s
            while (i >= 0 && j >= 0) {
                if (s.charAt(i) == t.charAt(j)) {
                    j--;
                }
                i--;
            }

            if (j < 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
