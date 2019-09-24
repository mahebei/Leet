/*
160. Intersection of Two Linked Lists
Easy

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode a = headA;
		ListNode b = headB;
		int lenA = 1, lenB = 1;
		while (a.next != null) {
			a = a.next;
			lenA++;
		}
		while (b.next != null) {
			b = b.next;
			lenB++;
		}
		if (a != b) return null;
		a = headA;
		b = headB;
		if (lenA >= lenB) {
			for (int i = 0; i < lenA - lenB; i++) {
				a = a.next;
			}
		} else {
			for (int i = 0; i < lenB - lenA; i++) {
				b = b.next;
			}
		}
		while (a != b) {
			a = a.next;
			b = b.next;
		}
		return a;
	}
}
