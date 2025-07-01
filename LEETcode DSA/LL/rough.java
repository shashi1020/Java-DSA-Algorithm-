class rough
{
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
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
        // printData(head);

        // int k=2;
        
        // head = removeNthFromEnd(head, 4);
        // printData(head);
        ListNode temp = head;
       int Size=0;
       while(temp!=null)
       {
           Size++;
           temp = temp.next;
       }
       System.out.println(Size);

    }

}