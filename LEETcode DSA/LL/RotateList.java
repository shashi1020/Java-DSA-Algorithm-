public class RotateList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        
        if(head.next == null || head == null || k==0)
        {
            return head;
        }
        ListNode temp = head;
        int length = 1;
        while(temp.next != null)
        {
            temp= temp.next;
            length++;
        }
        temp.next = head;
        k = k % length;
        int stepsToNewHead = length - k;
        ListNode newTail = temp;
        for(int i = 0; i<stepsToNewHead; i++)
        {
            newTail = newTail.next;
        }
        head = newTail.next;
        newTail.next = null; 
        return head; 
    }

    public static void printData(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void addLast(int val) {
        ListNode newNode = new ListNode(val);
        Size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public static ListNode head;
    public static ListNode tail;
    public static int Size;
    public static void main(String[] args) {
        
        addLast(1);
        addLast(2);
        addLast(3);
        addLast(4);
        addLast(5);
        printData(head);
        head = rotateRight(head,2);
        printData(head);

    }
} 
    






