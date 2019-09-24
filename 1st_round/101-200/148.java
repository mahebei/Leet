/*
148. Sort List
Medium

Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
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
	public ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				curr.next = left;
				left = left.next;
			} else {
				curr.next = right;
				right = right.next;
			}
			curr = curr.next;
		}
		while (left != null) {
			curr.next = left;
			curr = curr.next;
			left = left.next;
		}
		while (right != null) {
			curr.next = right;
			curr = curr.next;
			right = right.next;
		}
		return dummy.next;
	}

	public ListNode sort(ListNode head) {
		if (head.next == null) return head;
		ListNode slow = head, fast = head, pre = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			pre = slow;
			slow = slow.next;
		}
		pre.next = null;
		head = sort(head);
		slow = sort(slow);
		return merge(head, slow);
	}

	public ListNode sortList(ListNode head) {
		if (head == null) return null;
		return sort(head);
	}
}
