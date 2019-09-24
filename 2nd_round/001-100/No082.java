package no001_100;

public class No082 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		ListNode p = new ListNode(0);
		p.next = head;
		boolean isDup = false;
		while (p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				p.next = p.next.next;
				isDup = true;
			} else {
				if (isDup) {
					p.next = p.next.next;
				} else {
					p = p.next;
				}
				isDup = false;
			}
		}
		return head;
	}
}
