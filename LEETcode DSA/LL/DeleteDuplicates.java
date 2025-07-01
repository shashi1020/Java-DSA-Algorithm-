import java.util.List;

public class DeleteDuplicates {
    
        static class ListNode{
            int val;
            ListNode next;
            ListNode(int val)
            {
                this.val = val;
                this.next = null;
            }
        }
        public static ListNode DeleteDuplicatess(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
    
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode curr = head;
    
            while (curr != null) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                if (prev.next == curr) {
                    prev = prev.next;
                } else {
                    prev.next = curr.next;
                }
                curr = curr.next;
            }
    
            return dummy.next;
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
    
                    
            head = DeleteDuplicatess(head);
            printData(head);
    
        }
    } 
        
    
    
    
    
