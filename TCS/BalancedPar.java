import java.util.Scanner;
import java.util.Stack;

public class BalancedPar {
    public static boolean balancedP(String s){
        if(s.length()==0)return true;

        Stack<Character>stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='(' || ch=='{' || ch=='[')stack.push(ch);
            if(ch==')'){
                if(stack.isEmpty() || stack.peek()!='(')return false;
                else stack.pop();
            }else if(ch=='}'){
                if(stack.isEmpty() || stack.peek()!='{')return false;
                else stack.pop();
            }else if(ch==']'){
                if(stack.isEmpty() || stack.peek()!='[')return false;
                else stack.pop();
            }
        }
        if(!stack.isEmpty())return false;
        return true;
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        if(balancedP(s)){
            System.out.println("balanced");
        }else{
            System.out.println("Not balanced");
        }

        sc.close();
    }
}
