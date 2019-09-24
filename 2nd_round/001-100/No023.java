package no001_100;

public class No023 {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dum = new ListNode(0);
		ListNode curr = dum;
		int idx = 0;
		while (idx != -1) {
			idx = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null) {
					if (lists[i].val < min) {
						idx = i;
						min = lists[i].val;
					}
				}
			}
			curr.next = new ListNode(min);
			curr = curr.next;
			lists[idx] = lists[idx].next;
		}
		return dum.next;
	}
}
