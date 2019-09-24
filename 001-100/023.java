/*
23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		int count = 0;
		while (count < lists.length) {
			count = 0;
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] == null) {
					count++;
					continue;
				}
				if (lists[i].val < min) {
					min = lists[i].val;
					index = i;
				}
			}
			if (index != -1) {
				ListNode newNode = new ListNode(min);
				newNode.next = dummy.next;
				dummy.next = newNode;
				lists[index] = lists[index].next;
			}
		}		
		ListNode res = new ListNode(Integer.MIN_VALUE);
		while (dummy.next != null) {			
			ListNode newNode = new ListNode(dummy.next.val);
			newNode.next = res.next;
			res.next = newNode;
			dummy.next = dummy.next.next;
		}
		return res.next;
	}
}
