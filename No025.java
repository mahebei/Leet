package no001_100;

public class No025 {
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode p1 = new ListNode(-1);
		p1 = head;
		ListNode p2 = new ListNode(-1);
		p2.next = head;
		head = p2;
		int count = 0;
		while (p1 != null) {
			count++;
			p1 = p1.next;
		}
		for (int i = 0; i < count / k; i++) {
			p1 = p2;
			p2 = p2.next;
			for (int j = 0; j < k - 1; j++) {
				ListNode tem = p2.next;
				p2.next = p2.next.next;
				tem.next = p1.next;
				p1.next = tem;
			}
		}
		return head.next;
	}

	public static void main(String[] args) {
		ListNode head0 = new ListNode(5);
		ListNode newNode = new ListNode(4);
		newNode.next = head0;
		head0 = newNode;
		newNode = new ListNode(3);
		newNode.next = head0;
		head0 = newNode;
		newNode = new ListNode(2);
		newNode.next = head0;
		head0 = newNode;
		newNode = new ListNode(1);
		newNode.next = head0;
		head0 = newNode;
		newNode = new ListNode(0);
		newNode.next = head0;
		head0 = newNode;
		ListNode temp = reverseKGroup(head0, 2);
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
	}
}
