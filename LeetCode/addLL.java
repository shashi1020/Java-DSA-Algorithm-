class addLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node head2;

    public static Node adddata(Node head1, Node head2)
    {
        Node res = new Node(0);
        Node temp = res;
        int carry = 0;

       while(head1 != null || head2 != null)
       {
        int sum = carry;
         if(head1 != null)
         {
            sum += head1.data;
            head1=head1.next;
         }
         if(head2 != null)
         {
            sum += head2.data;
            head2=head2.next;
         }

         res.next = new Node(sum % 10);
         res = res.next;
         carry = sum / 10;

       }
       if(carry > 0)
       {
        res.next = new Node(carry);
       }

       return temp.next;
    }

    public static void main(String[] args) {
        head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(3);
         

        System.out.println("Data of the third node in the first linked list: " + head.next.next.data);

        head2 = new Node(5);
        head2.next = new Node(6);
       
        head2.next.next = new Node(4);

        System.out.println("Data of the third node in the second linked list: " + head2.next.next.data);
        Node resNode = adddata(head, head2);

        Node temp = resNode;
        while(temp != null)
        {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }
}
