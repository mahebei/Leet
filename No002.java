package no001_100;

public class No002 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dum = new ListNode(0);
		ListNode curr = dum;
		int carry = 0;
		while (l1 != null || l2 != null || carry == 1) {
			int tem = carry;
			if (l1 != null) {
				tem += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				tem += l2.val;
				l2 = l2.next;
			}
			curr.next = new ListNode(tem % 10);
			curr = curr.next;
			carry = tem / 10;
		}
		return dum.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		ListNode res = addTwoNumbers(l1, l2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
