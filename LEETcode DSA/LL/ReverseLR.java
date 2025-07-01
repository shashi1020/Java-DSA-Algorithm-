
public class ReverseLR {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node reverseBetween(Node head, int left, int right) {
        if (head == null || head.next == null) {  // Simplified null check
            return head;
        }

        Node temp = head;
        Node prev = null;
        
        for (int i = 1; i < left; i++) {  // Move temp to the left-th node
            prev = temp;
            temp = temp.next;
        }

        Node start = temp;
        Node prev2 = null;
        Node next2 = null;
        for (int i = left; i <= right; i++) {  // Reverse the sublist
            next2 = temp.next;
            temp.next = prev2;
            prev2 = temp;
            temp = next2;
        }

        if (prev != null) {  // Reconnect the reversed sublist with the previous part
            prev.next = prev2;
        } else {  // If left is 1, update head
            head = prev2;
        }

        start.next = temp;  // Reconnect the reversed sublist with the next part

        return head;
    }

    public static Node head;  // No change
    public static Node tail;  // No change
    public static int Size = 0;  // No change

    public void printData() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    public void addLast(int val) {
        Node newNode = new Node(val);
        Size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public static void main(String[] args) {
        ReverseLR ll = new ReverseLR();
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(4); 
        ll.addLast(3);
        ll.printData();
        System.out.println();
        head = ll.swapPairs(head);
        ll.printData();
    }

    public Node swapPairs(Node head) {
        Node dummy=new Node(0);
        Node prev = dummy;
        dummy.next = head;
        
        while(prev.next!=null && prev.next.next!=null)
        {
            Node curr = prev.next;
            Node temp = curr.next;


            curr.next = temp.next;
            temp.next = curr;
            prev.next = temp;

            prev = curr;
        }
        return dummy.next;
    }
}
