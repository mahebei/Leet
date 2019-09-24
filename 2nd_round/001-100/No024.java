package no001_100;

public class No024 {
	public ListNode swapPairs(ListNode head) {
		ListNode dum = new ListNode(0);
		dum.next = head;
		head = dum;
		while (head.next != null && head.next.next != null) {
			ListNode tem = head.next.next.next;
			head.next.next.next = head.next;
			head.next = head.next.next;
			head.next.next.next = tem;
			head = head.next.next;
		}
		return dum.next;
	}
}
