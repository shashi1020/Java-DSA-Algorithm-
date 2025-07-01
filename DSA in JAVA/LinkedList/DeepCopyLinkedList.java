public class DeepCopyLinkedList {
    static class Node {
        int data;
        Node next;
        Node random;

        Node(int val) {
            this.data = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node head;

    // Add a new node at the end of the list with a random pointer pointing to the node at random_index
    public static void AddLast(int data, int random_index) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;

        // Assign random pointer
        Node temp = head;
        while (random_index > 0 && temp != null) {
            temp = temp.next;
            random_index--;
        }
        newNode.random = temp;
    }

    // Create a deep copy of the list
    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        Node current = head;
        
        // First pass: Make a copy of each node and link them together side-by-side
        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        
        current = head;
        
        // Second pass: Assign random pointers for the copied nodes
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Third pass: Restore the original list and extract the copied list
        current = head;
        Node dummy = new Node(0);
        Node copy, copyCurrent = dummy;

        while (current != null) {
            Node next = current.next.next;

            // Extract the copy
            copy = current.next;
            copyCurrent.next = copy;
            copyCurrent = copy;

            // Restore the original list
            current.next = next;

            current = next;
        }

        return dummy.next;
    }

    // Print the data of the list along with random pointers
    public static void printData(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("Data: " + temp.data);
            if (temp.random != null) {
                System.out.print(", Random points to: " + temp.random.data);
            } else {
                System.out.print(", Random points to: null");
            }
            System.out.println();
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Adding nodes with respective random pointers
        AddLast(7, -1);  // Random index -1 means null
        AddLast(13, 0);  // Random index 0 points to first node
        AddLast(11, 4);  // Random index 4 points to the fourth node (value 1)
        AddLast(10, 2);  // Random index 2 points to the third node (value 11)
        AddLast(1, 0);   // Random index 0 points to first node

        // Print the original list
        // System.out.println("Original list:");
        // printData(head);

        // Create a deep copy of the list
        Node copiedList = copyRandomList(head);

        // Print the copied list
        // System.out.println("Copied list:");
        // printData(copiedList);
    }
}
