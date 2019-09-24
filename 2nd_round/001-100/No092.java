package no001_100;

public class No092 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode f = head;
		ListNode s = new ListNode(0);
		s.next = head;
		head = s;
		while (m-- > 1) {
			n--;
			f = f.next;
			s = s.next;
		}
		while (n-- > 1) {
			ListNode temp = f.next;
			f.next = temp.next;
			temp.next = s.next;
			s.next = temp;
		}
		return head.next;
	}
}
