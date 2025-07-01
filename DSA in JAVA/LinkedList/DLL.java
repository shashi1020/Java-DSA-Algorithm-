public class DLL {
    class Node{
        Node prev;
        int data;
        Node next;
        
        public Node(int data)
        {
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int Size;

    public void addFirst(int data)
    {
        Node newN = new Node(data);
        Size++;
        if(head == null)
        {
            head = tail = newN;
            return;
        }
        newN.next = head;
        head.prev = newN;
        head = newN;
    }

    public void addLast(int data)
    {
        Node newN = new Node(data);
        Size++;
        if(head == null)
        {
            head = tail = newN;
        }
        tail.next = newN;
        newN.prev = tail;
        tail = newN;
    }

    public int removeFirst()
    {
        if(head == null)
        {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
    }
    public int removeLast()
    {
        if(head == null)
        {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        int val = tail.data;
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        temp = null;
        return val;
    }

    public void reverseDLL()
    {
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void printData()
    {
        Node temp = head;

        while (temp != null) {
                System.out.print(temp.data + " <-> ");
                temp  = temp.next;            
        }
        System.out.print("NULL");
        
    }


    public static void main(String[] args) {
        DLL DLL = new DLL(); 
        DLL.addFirst(1);
        DLL.addFirst(0);
        DLL.addLast(2);
        DLL.addLast(3);
        DLL.printData();
        DLL.reverseDLL();
        System.out.println();
        DLL.printData();
    }
}
