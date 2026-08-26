import java.util.ArrayList;
import java.util.Scanner;

class Node{
    Node next;
    int data;

    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class Ques1{

    public static Node insertAtEnd(Node head,int data){
        Node newNode =new Node(data);

        if(head==null){
            return newNode;
        }

        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }

    public static Node insertFirst(Node head,int data){
        Node newNode=new Node(data);
        newNode.next=head;
        return newNode;
    }

    public static void printListArrayList(Node head,ArrayList<Integer>list){
      
        Node temp=head;
        while (temp!=null) {
            // System.out.print(temp.data+" ");
            list.add(temp.data);
            temp=temp.next;
        }
        // System.out.println();
    }
     public static void printList(Node head){
      
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void reverse(ArrayList<Integer>list){

        for(int i=list.size()-1;i>=0;i--){
            System.err.print(list.get(i)+" ");
        }
    }


    public static Node reverseList(Node head){
        // if(head==null)return head;
        // Node prev=null;
        // Node curr=head;
        // while(curr!=null){
        //    Node next=curr.next;
        //    curr.next=prev;
        //    prev=curr;
        //    curr=next;
        // }
        // return prev;

        if(head==null || head.next==null)return head;
        Node newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;

    }
 
    public static Node deleteHead(Node head){
        if(head==null)return head;

        Node temp=head.next;
        head.next=null;
        return temp;
    }

    public static int middleNode(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    public static int findNthElement(Node head,int n){
        Node fast=head;
        int count=1;
        while(count<n){
            if (fast.next == null) return -1;  
            fast=fast.next;
            count++;
        }
        Node slow=head;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow.data;

    }

    public static Node mergeTwoList(Node head1, Node head2){
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                dummy.next=head1;
                head1=head1.next;
            }else{
                dummy.next=head2;
                head2=head2.next;
            }
            dummy=dummy.next;
        }
        if(head1!=null){
            dummy.next=head1;
        }else{
            dummy.next=head2;
        }

        return temp.next;

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        Node head1=null;
        while(n-->0){
            int value= sc.nextInt();
            head1=insertAtEnd(head1,value);
        }

        Node head2=null;
        int m=sc.nextInt();
        while(m-->0){
            int value= sc.nextInt();
            head2=insertAtEnd(head2,value);
        }
        // int x=sc.nextInt();
        // int ans=findNthElement(head,x);
        // System.out.println(ans==-1?"Invalid": ans);
        Node head=null;
        head=mergeTwoList(head1,head2);
       printList(head);
       
        sc.close();

    }
}