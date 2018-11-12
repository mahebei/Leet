/*
19. Remove Nth Node From End of List

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
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
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode n0 = head;
		ListNode n1 = null;
		int margin = 0;
		while (n0 != null) {
			if (margin < n) {
				margin++;
			} else if (margin == n) {
				n1 = head;
				margin++;
			} else {
				n1 = n1.next;
			}
			n0 = n0.next;
		}
		if(n1 == null) {
			head = head.next;
		}
		else if (n1.next != null) {
			n1.next = n1.next.next;
		}
		return head;
	}
}
