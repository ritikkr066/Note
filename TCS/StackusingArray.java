public class StackusingArray{

    static int[] stack=new int[100];
    static int top=-1;

    public static void push(int x){
        if(top==stack.length-1){
            System.out.println("Stack Overflow ");
        }
        stack[++top]=x;
    }

    public static int pop(){
        if(top==-1){
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top--];
    }

    public static int peek(){
        if(top==-1){
            System.out.println("No element Found");
            return -1;
        }

        return stack[top];
    }

    public static boolean isEmpty(){
        if(top==-1){
            return true;
        }

        return false;
    }

    public static void main(String args[]){
        push(10);
        push(20);
        push(30);

        System.out.println(peek());
        System.out.println(pop());
        System.out.println(peek());
        System.out.println(isEmpty());
    }
}