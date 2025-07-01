public class practice {
    class Node{
        Node next;
        Node Random;
        int val;
        Node(int x)
        {
            this.val = x;
            this.next = null;
            this.Random = null;
        }
    }
/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.
*/
    public static Node CopyLLwithRandomPointer(Node head)
    {
        if(head==null) return null;
        Node current = head;
        // first pass : copy LL next pointer
        while(current != null)
        {
            Node newN = new Node(current.val);
            newN.next = current.next;
            current.next = newN;
            current = newN.next;
        }
        current = head;
        // first pass : copy LL random pointer
        while(current != null)
        {
            if(current.Random!=null)
            {
                current.next.Random = current.Random.next;
            }
            current = current.next.next;
        }
        current = head;
        Node next;
        Node dummy = new Node(0);
        Node copy, copyCurrent = dummy;

        while(current != null)
        {
            next = current.next.next;
            copy = current.next;
            copyCurrent.next = copy;
            copyCurrent = copy;
            current.next = next;
            current= next;

        }   
        return dummy.next;

    }

    public static void main(String[] args) {
        
    }
}
