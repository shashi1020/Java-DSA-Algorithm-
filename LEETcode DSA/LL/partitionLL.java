class partitionLL{
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode PartitionList(ListNode head, int x)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode less = dummy1;
        ListNode greater = dummy2;
        ListNode current = head;

        while(current!=null)
        {
            if(current.val < x)
            {
                less.next = current;
                less = less.next;
                
            }else{
            greater.next = current;
            greater = greater.next;
            
        }
        current = current.next;
        }
        greater.next = null;
        less.next = dummy2.next;
        return dummy1.next;
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
    addLast(4);
    addLast(3);
    addLast(2);
    addLast(5);
    addLast(2);
    printData(head);
    // System.out.println(tail.val);
            
    head = PartitionList(head, 3);
    printData(head);

}
} 


