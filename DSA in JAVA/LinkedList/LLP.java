public class LLP {
    public class Node
    {
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

    public void printData(Node head)
    {
        Node temp = head;

        while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp  = temp.next;            
        }
        System.out.print("NULL");
        
    }

    public void printCircularLL()
    {
        Node temp = head;

        do{
                System.out.print(temp.data + " -> ");
                temp  = temp.next;            
        }while(temp != tail.next);
        System.out.print("NULL");
        
    }

    public void AddFirst(int data)
    {
        Node newNode = new Node(data);
        Size++;
        if (head == null) 
        {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        
    }

    public void AddLast(int data)
    {
        Node newNode = new Node(data);
        Size++;
        if(head == null)
        {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        // tail.next = head.next; (it creates a circular linked list)
    }
    
    public void Add(int idx, int data)
    {
        if(idx == 0)
        {
            AddFirst(data);
            return;
        }
        Node NewNode = new Node(data);
        Size++;
        Node temp = head;
        while(idx != 1)
        {
            temp = temp.next;
            idx--;
        }
        NewNode.next = temp.next;
        temp.next = NewNode;
    }
    public int removeFirst()
    {
        if(Size == 0)
        {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }
        if (Size == 1) {
            int val = head.data;
            head = tail = null;
            Size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        Size--;
        return val;
    }
  
    public int removeLast()
    {
        if(Size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(Size == 1)
        {
            int val = head.data;
            head = tail = null;
            Size = 0;
            return val;
        }
        
        Node prev = head;
        
       for(int i = 0; i < Size-1; i++)
        {
            prev = prev.next;
            i++;
        }
        int val = prev.next.data;
        prev.next = null;
        Size--;
        tail = prev;
        return val;
    }
    
    public int Delete_CertNode(int pos){
        if(pos == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }
        if(pos == 1)
        {
            int val = head.data;
            head = head.next;
            Size = 0;
            return val;
        }
        
        if(pos == Size){
            return removeLast();
        }
        Node temp = head;
        Node prev = head;
        while(pos != 1)
        {
            prev = temp;
            temp = temp.next;
            pos--;
        }
        int val = temp.data;
        prev.next = temp.next;
        Size--;
        return val;
    }
    public int SearchKey(int key)
    {
        Node temp = head;
        int i=0;
        while(temp != null)
        {
            if(temp.data == key)
            {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    
    public int helper(Node head, int key)
    {
        if(head==null)
        {
            return -1;
        }
        if(head.data == key)
        {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1)
        {
            return -1;
        }
        return idx+1;

    }

    public int SearchRec(int key){

        return helper(head, key);
    }

    public void ReverseLinkedList(Node head)
    {
        // time complexity -> O(n)
        Node prev = null;
        Node current = tail = head;
        Node next;
        
        while(current!=null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void removeNthfromEnd(int n)
    {
        int sz = 0;
        Node temp = head;
        while(temp != null)
        {
            temp = temp.next;
            sz++;
        }
        if(n==sz)
        {
            head = head.next;
            return;
        }

        int iTofind = sz-n;
        Node prev = head;
        int i=1;
        while(i < iTofind)
        {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public boolean checkPali(Node head)
    {
        if(head==null || head.next == null)
        {
            return true;
        }
        Node midNode = Findmid(head);
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null)
        {
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;

        }
        Node left = prev;
        Node Right = head;
        while(Right != null){
        
        if(left.data != Right.data)
        {
            return false;
        }
        left = left.next;
        Right = Right.next;
    }

        return true;
    }

    public Node Findmid(Node head)
    {
        Node turtle = head;
        Node hare = head;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next; 
        }
        return turtle;
    }

    public boolean isCycle()
    {
        Node slow = head;
        Node Fast = head;

        while(Fast != null && Fast.next!=null)
        {
            slow = slow.next;
            Fast = Fast.next.next;
            if(slow ==  Fast)
            {
                return true;
            }
        }
        return false;
    }

    public void RemoveCycle()
    {
       
        Node slow = head;
        Node fast = head;
       
        boolean cycle = false;

        while(fast != null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
              cycle = true;
              break;   
            }
        }
        if(cycle == false)
        {
            return;
        }
        slow = head;
        Node prev = null;
        while(slow != fast)
        {
            prev = fast; 
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }
   

    public Node reverseBetween(Node head, int left, int right)
    {
        Node temp, temp2;
        temp = head;
        Node prev = temp;
        Node next1 = temp.next;
        // int rightnode = right-left;
        while(left > 0)
        {
            prev = temp;
            temp = temp.next;
            next1 = temp.next;
        }
        temp2 = temp;
        Node prev2 = temp2;
        Node next2 = temp2.next;
        while(right > 0)
        {
            prev2 = temp2;
            temp2 = temp2.next;
            next2 = temp2.next;
        }
        temp.next = next2;
        prev2.next = temp;
        temp2.next = next1;
        prev.next = temp2;

        return head;
    }

    public static void main(String[] args) 
    {
        
        LLP l = new LLP();
        
        l.AddLast(1);
        l.AddLast(2);
        l.AddLast(3);
        l.AddLast(4);
        l.AddLast(5);
        l.AddLast(6);
        l.printData(head);
        head = l.reverseBetween(head, 2, 5);
        System.out.println();
        l.printData(head);
         

        System.out.println("\nSize = " + Size);

    }
    

}
