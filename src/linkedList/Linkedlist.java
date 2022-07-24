package linkedList;

public class Linkedlist {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(4);
        head.insert(5);
        head.insert(7);
        head.insert(9);
        head=head.insert(2,19);
        head.printList();
        head = head.reverse();
        head.printList();
    }


}
class Node<T>{
    int data;
    Node<T> next;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int data){
        Node<T> newNode = new Node<>(data);
        Node<T> cur = this;
        while (cur.next!=null) cur=cur.next;
        cur.next = newNode;

    }
    public Node<T> insert(int pos, int data){
        Node<T> newNode = new Node<>(data);
        if(pos==0){
            newNode.next = this;
            return newNode;
        }
        Node<T> prev = this;
        for(int i = 0;i<pos-1;i++){
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return this;
    }
    public Node<T> reverse(){
        Node<T> cur = this;
        Node<T> prev = null;
        while(cur!=null){
            Node<T> temp = cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }

    // Reverse LinkedList recursively
    public Node<T> reverseRecursive(Node<T> head){
        if(head==null || head.next==null){
            return head;
        }
        Node<T> newHead = reverseRecursive(head);
        Node<T> headNew = head.next;
        headNew.next = head;
        head.next=null;
        return newHead;

    }
    public void printList(){
        Node<T> cur = this;
        while(cur!=null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
