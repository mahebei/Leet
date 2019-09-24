/*
234. Palindrome Linked List
Easy

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
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
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) return true;
		ListNode s = new ListNode(0);
		s.next = head;
		ListNode f = s;
		while (f.next != null && f.next.next != null) {
			s = s.next;
			f = f.next.next;
		}
		if (f.next != null) {
			s = s.next;
			f = f.next;
		}
		while (s.next != f) {
			ListNode tem = s.next;
			s.next = s.next.next;
			tem.next = f.next;
			f.next = tem;
		}
		s = head;
		while (f != null) {
			if (s.val != f.val) return false;
			s = s.next;
			f = f.next;
		}
		return true;
	}
}
