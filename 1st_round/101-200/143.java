/*
143. Reorder List
Medium

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public void reorderList(ListNode head) {
		if (head == null) return;
		LinkedList<ListNode> list = new LinkedList<>();
		ListNode p = head;
		while (p.next != null) {
			p = p.next;
			list.add(p);
		}
		p = head;
		while (!list.isEmpty()) {
			p.next = list.pollLast();
			p = p.next;
			p.next = list.pollFirst();
			p = p.next;
		}
		if (p != null) p.next = null;
		return;
	}
}
