import org.w3c.dom.Node;

class removeNthNode {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
   public static ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode temp = head;
       int Size=0;
       while(temp!=null)
       {
           Size++;
           temp = temp.next;
       }
       System.out.println(Size);
       int Nth = Size-n+1;
       if(Nth==1)
       {
        head = head.next;
        return head;
       }
       ListNode prev = null;
       ListNode curr = head;
       
        while(Nth!=1){
           prev = curr;
           curr = curr.next;
           Nth--;
        }
       
       prev.next = curr.next;
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

                
        head = removeNthFromEnd(head, 5);
        printData(head);

    }
} 
    

