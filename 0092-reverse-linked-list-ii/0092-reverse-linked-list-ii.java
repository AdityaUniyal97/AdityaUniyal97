/**
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //Step 1: locate leftprev and curr
        ListNode leftprev = dummy;
        for(int i = 1 ; i < left ; i++)
        {
            leftprev = leftprev.next;
        }
        ListNode curr = leftprev.next;

        // Reverse the Sublist
        ListNode prev = null;
        for(int i = left ;i <= right ; i++)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Recoonect
        leftprev.next.next = curr;   //Connect tail of reversed sublist
        leftprev.next = prev;           //connect head of reverse sublist
        return dummy.next;
    }
}