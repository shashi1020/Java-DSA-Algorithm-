class RetUniqueNodes {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode returnUniqueNodes(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }

        ListNode temp = head;
        ListNode temp2 = head;
        ListNode prev =  head;
        
        while(temp.next != null)
        {
           
            temp2 = temp.next;
            if(temp.val == temp2.val)
            {
                prev.next = temp2.next;
                returnUniqueNodes(head);
                
            }
            prev = temp;
            temp = temp.next; 
        }
                                                                                                                                                                          
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
        addLast(1);
        addLast(1);
        addLast(1);
        addLast(3);
        addLast(4);
        addLast(4);
        addLast(5);
        addLast(5);
        printData(head);

                
        head = returnUniqueNodes(head);
        printData(head);

    }
} 
    



