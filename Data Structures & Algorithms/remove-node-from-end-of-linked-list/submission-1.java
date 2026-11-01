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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (; n > 1; n--) {
            p1 = p1.next;
        }
        ListNode nodeToDelete = head;
        ListNode prevToDelete = null;
        while (p1.next != null) {
            p1 = p1.next;
            prevToDelete = nodeToDelete;
            nodeToDelete = nodeToDelete.next;
        }
        if (prevToDelete == null) {
            // delete head
            return head.next;
        }
        prevToDelete.next = nodeToDelete.next;
        return head;
    }
}
