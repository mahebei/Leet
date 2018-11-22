/*
82. Remove Duplicates from Sorted List II
Medium

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
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
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode tail = head.next;
		while (tail != null) {
			tail = tail.next;
			if (tail != null && tail.val == head.next.val) {
				while (tail != null && tail.val == head.next.val) {
					tail = tail.next;
				}
				head.next = tail;
			}
			if (head.next != null && head.next.next != null && head.next.val != head.next.next.val) {
				head = head.next;
				tail = head.next;
			}
		}
		return dummy.next;
	}
}
