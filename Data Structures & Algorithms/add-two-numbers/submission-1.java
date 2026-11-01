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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return l2;
        } else if (l2.val == 0) {
            return l1;
        }
        ListNode iter1 = l1;
        ListNode iter2 = l2;
        ListNode resHead = new ListNode(0);
        ListNode resIter = resHead;
        ListNode resIterPrev = null;
        do {
            int sum = iter1.val + iter2.val + resIter.val;
            resIter.next = sum >= 10 ? new ListNode(1) : new ListNode(0);
            resIter.val = sum >= 10 ? sum - 10 : sum;
            resIterPrev = resIter;
            resIter = resIter.next;
            iter1 = iter1.next;
            iter2 = iter2.next;
        } while (iter1 != null && iter2 != null);
        if (iter1 == null && iter2 == null) {
            if (resIter.val == 0) {
                resIterPrev.next = null;
            }
        } else {
            ListNode longerListIter = (iter2 == null) ? iter1 : iter2;
            while (resIter.val == 1 && longerListIter != null) {
                int sum = 1 + longerListIter.val;
                resIter.next = sum >= 10 ? new ListNode(1) : new ListNode(0);
                resIter.val = sum >= 10 ? sum - 10 : sum;
                resIterPrev = resIter;
                resIter = resIter.next;
                longerListIter = longerListIter.next;
            }
            if (resIter.val == 0) {
                resIterPrev.next = null;
            }
        }
        return resHead;
        
    }
}
