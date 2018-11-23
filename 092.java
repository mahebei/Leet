/*
92. Reverse Linked List II
Medium

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
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
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		while (--m > 0) {
			head = head.next;
			n--;
		}
		ListNode tail = head.next;
		while (--n > 0) {
			ListNode tem = head.next;
			head.next = tail.next;
			tail.next = tail.next.next;
			head.next.next = tem;
		}
		return dummy.next;
	}
}
