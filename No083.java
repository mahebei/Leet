package no001_100;

public class No083 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		ListNode p = head;
		while (p.next != null) {
			if (p.val == p.next.val) {
				p.next = p.next.next;
			} else p = p.next;
		}
		return head;
	}
}
