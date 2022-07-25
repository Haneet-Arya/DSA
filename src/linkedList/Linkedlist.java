package linkedList;

public class Linkedlist {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(4);
        head.insert(5);
        head.insert(7);
        head.insert(9);
        head=head.insert(2,19);
        Node<Integer> cycleStart = head.next.next;
        head.insert(72);
        head.insert(89);
        Node<Integer> last = head;
        while(last.next!=null) last = last.next;
        last.next = cycleStart;
        Node<Integer> cyclePresent = head.floydAlgoToFindCycleStartPos(head);
        System.out.println(cyclePresent.data);
        head.printList();
//        head = head.reverse();
//        head.printList();
    }


}

class Node<T> {
    int data;
    Node<T> next;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int data) {
        Node<T> newNode = new Node<>(data);
        Node<T> cur = this;
        while (cur.next != null) cur = cur.next;
        cur.next = newNode;

    }

    public Node<T> insert(int pos, int data) {
        Node<T> newNode = new Node<>(data);
        if (pos == 0) {
            newNode.next = this;
            return newNode;
        }
        Node<T> prev = this;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return this;
    }

    public Node<T> reverse() {
        Node<T> cur = this;
        Node<T> prev = null;
        while (cur != null) {
            Node<T> temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    // Reverse LinkedList recursively
    public Node<T> reverseRecursive(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        // will get the new head from the last recursive step from the above if statement
        Node<T> newHead = reverseRecursive(head);
        // reversing the chain
        Node<T> next = head.next;
        next.next = head;
        head.next = null;
//        returning the main head
        return newHead;

    }

    public void printList() {
        Node<T> cur = this;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // Finding middle of LinkedList
    /* slow taking one step at a time and fast taking two step at a time */
    public Node<T> middle() {
        Node<T> slow = this;
        Node<T> fast = this;
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // finding the linkedlist is palindrome or not
    /* Logic is to find the middle of the linked list and then reverse it from there and start checking if the reversed linkedlist data
    is equal to the curr data and continue ot by iterating the both list
     */
    public boolean isPalindrome(Node<T> head) {
        if (head == null) return true;
        Node<T> mid = head.middle();
        Node<T> last = mid.next.reverse();
        Node<T> cur = head;
        while (last != null) {
            if (last.data != cur.data) return false;
            last = last.next;
            cur = cur.next;
        }
        return true;
    }
//   Detect and rmeove Cycle in a linkedList
//    Cycle can be detected using a hashmap where we can put the each element in the hashmap and when we get any element another time
//    we consider that cycle is starting from that particular node but it will take O(n) space complexity for hashmap

    /**
     * To overcome the space complexity we use Floyd's cycle detection algorithm with use two pointer i.e. slow and fast and
     * not use any space complexity, if fast reach to null cycle doesn't exist and if fast and slow reach the same destination then the
     * cycle exist
     * To detect from where the cycle is starting we take 2 ptrs one from the starting and one from the destination we move them by 1-1 positions
     * and surely they will meet at the position where cycle is starting
     * Proof of above -
     * Dist of slow x 2 = Dist of fast
     * (A + m(B + C) + B )*2 = A + n(B + C) + B
     * here m is number of rounds of cycle slow ptr has done and n is number of rounds of cycle fast ptr has done
     * A distance is of straight chain B is the distance after A where slow and fast meet and C is the distance left to reach the cycle staring
     * again
     * the above equation will come to the simplification as A+B = (n-m)(B+C)
     * where n-m = X is integer so after revolving certain rounds of cycle A will be equal to (XB + XC) + C
     * <img src = "https://res.cloudinary.com/dwadwwch7/image/upload/v1658743335/DSA/Screenshot_2022-07-25_at_3.32.09_PM_nofwjv.png">
     * */

    public Node<T> floydAlgoToFindCycleStartPos(Node<T> head){
        Node<T> meet = detectCycle(head);
        if(meet==null) return null;
        Node<T> start = head;
        Node<T> prev = head;
        while(meet!=start){
            prev=meet;
            meet = meet.next;
            start = start.next;
        }
        prev.next=null;
        return start;
    }
    public Node<T> detectCycle(Node<T> head){
        Node<T> slow = head;
        Node<T> fast = head;
        while(fast!=null || fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) return slow;
        }
        return null;
    }


}
