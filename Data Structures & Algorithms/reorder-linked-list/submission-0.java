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

        // for (ListNode ln : lst) {
        //     System.out.print(ln.val);
        //     System.out.print(" ");
        // }
        // System.out.println();
        int n = lst.size();
        for (int i = 0; i < n / 2; i++) {
            // System.out.println(i);
            ListNode ith = lst.get(i);
            ListNode nith = lst.get(n - 1 - i);
            ith.next = nith;
            nith.next = (i < n / 2 - 1) ? lst.get(i+1) : null;
        }

        if (n % 2 == 1) {
            lst.get(n / 2 + 1).next = lst.get(n / 2);
            lst.get(n / 2).next = null;
        }
        // for (ListNode ln : lst) {
        //     System.out.print(ln.val + "->" + (ln.next == null ? "null" : ln.next.val));
        //     System.out.print(" ");
        // }
        // System.out.println();
        // head = new ListNode();
        // lst.get(lst.size()-1).next = null;
        return;
    }
}
