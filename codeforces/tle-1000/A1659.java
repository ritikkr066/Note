import java.util.Scanner;

public class A1659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            int b = sc.nextInt();
            int parts = b + 1;
            int c = r / parts;
            int extra = r % parts;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < parts; i++) {
                int rCount = c;
                if (i < extra) rCount++;

                for (int j = 0; j < rCount; j++) {
                    sb.append("R");
                }

                if (i < b) {
                    sb.append("B");
                }
            }

            System.out.println(sb.toString());
        }
    }
}



// import java.util.Scanner;

// public class A1659 {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int t=sc.nextInt();
//         while(t-->0){
//             int n=sc.nextInt();
//             int r=sc.nextInt();
//             int b=sc.nextInt();
//              int c = (int) Math.ceil((double) r / (b + 1));

//             StringBuilder sb=new StringBuilder();
//                 int count=0;
//                 for(int i=0;i<r;i++){
//                     sb.append("R");
//                     count++;
//                     if(count==c && b>0){
//                         sb.append("B");
//                         count=0;
//                         b--;
//                     }
//                 }
//                 while(b>0){
//                     sb.append("B");
//                     b--;
//                 }
            
//             System.out.println(sb.toString());
//         }
//     }
// }
