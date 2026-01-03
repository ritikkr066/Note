// import java.util.Scanner;

// public class t1071 {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int t=sc.nextInt();
//         while (t-->0) {
//             long x=sc.nextLong();
//             long y=sc.nextLong();
           
//             if(x>=y){
//                 if(x%2==0){
//                     System.out.println(x*x-y+1);
//                 }else{
//                     System.out.println((x-1)*(x-1)+y);
//                 }
//             }else{
//                 if(y%2==0){
//                     System.out.println((y-1)*(y-1)+x);
//                 }else{
//                     System.out.println(y*y-x+1);
//                 }    
//             }
//         }
//     }
// }


import java.io.*;

public class t1071 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            long x = fs.nextLong();
            long y = fs.nextLong();

            if (x >= y) {
                if (x % 2 == 0) {
                    sb.append(x * x - y + 1);
                } else {
                    sb.append((x - 1) * (x - 1) + y);
                }
            } else {
                if (y % 2 == 0) {
                    sb.append((y - 1) * (y - 1) + x);
                } else {
                    sb.append(y * y - x + 1);
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, res = 0;
            do c = read(); while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long res = 0;
            do c = read(); while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res * sign;
        }
    }
}

