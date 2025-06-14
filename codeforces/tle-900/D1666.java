import java.util.Scanner;

public class D1666{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            String s=sc.next();
            String t=sc.next();
            int S[]=new int[26];
            for(int i=0;i<s.length();i++){
                S[s.charAt(i)-'A']++;
            }

            int T[]=new int[26];
            for(int i=0;i<t.length();i++){
                T[t.charAt(i)-'A']++;
            }
            boolean flag=false;
            StringBuilder sb=new StringBuilder(s);
            for(int i=0;i<26;i++){
                if(S[i]<T[i]){
                    flag=true;
                    break;
                }
                if(S[i]==0 || S[i]==T[i])continue;
                StringBuilder helper =new StringBuilder();
                for(int j=0;j<sb.length();j++){
                    if(sb.charAt(j)!=(char)(i+'A')){
                        helper.append(sb.charAt(j));
                    }else{
                        if(S[i]>T[i]){
                            S[i]--;
                        }else{
                            helper.append(sb.charAt(j));
                        }
                    }
                }
                sb=new StringBuilder(helper);
            }
            if(flag){
                System.out.println("NO");
            }else{
                if(t.equals(sb.toString())){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}