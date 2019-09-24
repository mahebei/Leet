/*
24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
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
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		if (head != null && head.next != null) {
			dummy.next = head;
			ListNode n1 = dummy;
			ListNode n0;
			while (n1.next != null && n1.next.next != null) {
				n0 = n1.next;
				n1.next = n0.next;
				n0.next = n1.next.next;
				n1.next.next = n0;
				n1 = n0;
			}
		}
		return dummy.next;
	}
}
