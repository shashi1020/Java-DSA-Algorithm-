public class isCycle {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode head;
    public static ListNode tail;
    
    public static void addlast(int data)
    {
        ListNode newN = new ListNode(data);
        if(head == null)
        {
            head = tail = newN;
        }
        tail.next = newN;
        tail = newN;
        tail.next = head.next;
    }
    public static boolean iscycle()
    {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                return true; 
            }
            
        }
        return false;

    }

    public static void printll()
    {
        ListNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        addlast(1);
        addlast(2);
        addlast(3);
        // printll();
        System.out.println(iscycle());
        
    }
}
