package no001_100;

public class No086 {
	public ListNode partition(ListNode head, int x) {
		if (head == null) return null;
		ListNode f = new ListNode(0);
		f.next = head;
		head = f;
        while (f.next != null && f.next.val < x) {
			f = f.next;
		}
        ListNode s = f;
		while (f.next != null) {
			if (f.next.val >= x) {
				f = f.next;
			} else {
				ListNode temp = f.next;
				f.next = f.next.next;
				temp.next = s.next;
				s.next = temp;
				s = s.next;
			}
		}
		return head.next;
	}
}
