import org.w3c.dom.Node;

public class reversekNodes {
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data =data;
            this.next = null;
        }
    }
    public static Node reverseKGroup(Node head, int k) {
        if(head==null || k==1)
        {
            return head;
        }
        int count = 0; 
        Node temp = head;
        while(temp!=null && count < k)
        {
            temp = temp.next;
            count++;
        }
        if(count<k)
        {
            return head;
        }
        Node curr =head;
        Node prev=null;
        Node next = null;
        count = 0;
        while(curr!=null && count<k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;

        }
        if(next != null)
        {
            head.next = reverseKGroup(next, k);
        }
        head = prev;
        return head;
    }

    public static void printData(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void addLast(int val) {
        Node newNode = new Node(val);
        Size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }
    public static Node head;
    public static Node tail;
    public static int Size;
    public static void main(String[] args) {
        addLast(1);
        addLast(2);
        addLast(3);
        addLast(4);
        addLast(5);
        printData(head);

        int k=2;
        
        head = reverseKGroup(head, 2);
        printData(head);

    }
}
