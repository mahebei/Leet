/*
002 Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode r = new ListNode(0);
	ListNode a = l1, b = l2, c = r;
	int carry = 0;
	while (a != null || b != null) {
		int sum = (a != null) ? a.val : 0;
		sum += (b != null) ? b.val : 0;
		sum += carry;
		carry = sum / 10;
		c.next = new ListNode(sum % 10);
		if (a != null) {
			a = a.next;
		}
		if (b != null) {
			b = b.next;
		}
		c = c.next;
	}
	if (carry == 1) {
		c.next = new ListNode(1);
	}
	return r.next;
}
