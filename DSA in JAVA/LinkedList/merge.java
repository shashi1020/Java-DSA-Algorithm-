public class merge {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public static ListNode head;
    public static ListNode tail;
    public static ListNode head2;
    public static ListNode tail2;

    public static void AddLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static void AddLast2(int data) {
        ListNode newNode = new ListNode(data);
        if (head2 == null) {
            head2 = tail2 = newNode;
            return;
        }
        tail2.next = newNode;
        tail2 = newNode;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // Append remaining nodes of list1 or list2 (if any) to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummy.next;
    }

    public static void printData(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        AddLast(1);
        AddLast(2);
        AddLast(4);
        AddLast2(1);
        AddLast2(3);
        AddLast2(4);
        head = mergeTwoLists(head, head2);
        printData(head);
    }
}
