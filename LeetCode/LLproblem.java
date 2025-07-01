public class leetcode {
    static class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static Node head2;
    public static Node tail2;

    public static void append(int data)
    {
        Node NewNode = new Node(data);
        if(head == null)
        {
            head = tail = NewNode;
            return;
        }   
        tail.next = NewNode;
        tail = NewNode;
    }
    public static void append2(int data)
    {
        Node NewNode = new Node(data);
        if(head2 == null)
        {
            head2 = tail2 = NewNode;
            return;
        }   
        tail2.next = NewNode;
        tail2 = NewNode;
    }
    public static void printLL(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data+" -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static Node addTwoNumbers(Node l1, Node l2)
    {
      
        Node dummy = new Node(-1);
        Node curr = dummy;
        int carry=0;
        while(l1 != null || l2!=null)
        {
            int sum = carry;
            if(l1 != null)
            {
                sum += l1.data;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                sum += l2.data;
                l2 = l2.next;
            }

            curr.next = new Node(sum%10);
            curr = curr.next;
            carry = sum/10;
        }
        if (carry > 0) {
            curr.next = new Node(carry);
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        append(2);
        append(4);
        append(3);
        printLL(head);
        append2(5);
        append2(6);
        append2(4);
        printLL(head2);

        Node sumnode = addTwoNumbers(head, head2);
        printLL(sumnode);
    }
}
