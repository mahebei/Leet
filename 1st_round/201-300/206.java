/*
206. Reverse Linked List
Easy

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
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
	public ListNode reverseList(ListNode head) {
		if (head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		while (head.next != null) {
			ListNode tem = dummy.next;
			dummy.next = head.next;
			head.next =dummy.next.next;
			dummy.next.next = tem;
		}
		return dummy.next;
	}
}
