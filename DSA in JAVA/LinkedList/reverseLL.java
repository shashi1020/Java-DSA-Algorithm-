public class reverseLL {

    public ListNode reverseBetween(ListNode head, int left, int right)
    {
        if(head.next == null || head == null)
        {
            return head;
        }
        ListNode temp, temp2;
        temp = head;
        ListNode prev = temp;
        ListNode next1 = temp.next;
        while(left > 0)
        {
            prev = temp;
            temp = temp.next;
            next1 = temp.next;
        }
        temp2 = temp;
        ListNode prev2 = temp2;
        ListNode next2 = temp2.next;
        int rightnode = right-left;
        while(rightnode > 0)
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

}/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right)
    {
        if(head.next == null || head == null)
        {
            return head;
        }
        ListNode temp, temp2;
        temp = head;
        ListNode prev = temp;
        ListNode next1 = temp.next;
        while(left > 0)
        {
            prev = temp;
            temp = temp.next;
            next1 = temp.next;
        }
        temp2 = temp;
        ListNode prev2 = temp2;
        ListNode next2 = temp2.next;
        int rightnode = right-left;
        while(rightnode > 0)
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


}
