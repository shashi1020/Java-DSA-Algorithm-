public class ZigZagLL {
        public class Node{ 
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int Size;

    public void addLast(int data)
    {
        Node newN = new Node(data);
        Size++;
        if(head == null)
        {
            head = tail = newN;
        }
        tail.next = newN;
        tail = newN;
    }

    public void printData()
    {
        Node temp = head;

        while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp  = temp.next;            
        }
        System.out.print("NULL");
        
    }

    public Node Findmid()
    {
        Node turtle = head;
        Node hare = head;

        while(hare != null && hare.next != null)
        {
            turtle = turtle.next;
            hare = hare.next.next;
        }
        return turtle;
    }

    public void ZigZag()
    {
        Node mid = Findmid();

        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node LH = head;
        Node RH = prev;
        Node nextL, nextR;
         while(LH != null && RH != null)
         {
            nextL = LH.next;
            nextR = RH.next;
            LH.next = RH;
            RH.next = nextL;
            LH = nextL;
            RH = nextR;
         }

    }

    

    public static void main(String[] args) {
        ZigZagLL ll = new ZigZagLL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.ZigZag();
        ll.printData();
    }

}
