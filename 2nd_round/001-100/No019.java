package no001_100;

public class No019 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tail = head;
		ListNode dum = new ListNode(0);
		dum.next = head;
		head = dum;
		while (n-- > 0) tail = tail.next;
		while(tail != null){
			tail = tail.next;
			head = head.next;
		}
		head.next = head.next.next;
		return dum.next;
	}
}
