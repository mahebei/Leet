package no001_100;

public class No021 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dum = new ListNode(0);
		ListNode curr = dum;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				curr.next = new ListNode(l1.val);
				curr = curr.next;
				l1 = l1.next;
			} else {
				curr.next = new ListNode(l2.val);
				curr = curr.next;
				l2 = l2.next;
			}
		}
		if (l1 == null) curr.next = l2;
		else curr.next = l1;
		return dum.next;
	}
}
