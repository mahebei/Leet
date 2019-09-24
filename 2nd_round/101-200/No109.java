package no001_100;

public class No109 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		ListNode s = new ListNode(0);
		ListNode f = new ListNode(0);
		s.next = head;
		f.next = head;
		if (f.next != null && f.next.next != null) {
			f = f.next.next;
			s = s.next;
		}
		TreeNode curr = new TreeNode(s.next.val);
		curr.right = sortedListToBST(s.next.next);
		s.next = null;
		curr.left = sortedListToBST(head);
		return curr;
	}
}
