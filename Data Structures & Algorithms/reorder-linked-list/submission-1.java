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
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        List<ListNode> lst = new ArrayList<>();
        ListNode iter = head;
        do {
            lst.add(iter);
            iter = iter.next;
        } while (iter != null);
        int n = lst.size();
        for (int i = 0; i < n / 2; i++) {
            ListNode ith = lst.get(i);
            ListNode nith = lst.get(n - 1 - i);
            ith.next = nith;
            nith.next = (i < n / 2 - 1) ? lst.get(i+1) : null;
        }

        if (n % 2 == 1) {
            lst.get(n / 2 + 1).next = lst.get(n / 2);
            lst.get(n / 2).next = null;
        }
    }
}
