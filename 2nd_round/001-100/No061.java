package no001_100;

public class No061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode f = head;
        int count = 1;
        while (f.next != null) {
            f = f.next;
            count++;
        }
        f = head;
        k %= count;
        if (k == 0)
            return head;
        while (k-- > 0) {
            f = f.next;
        }
        ListNode s = head;
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }
        f.next = head;
        head = s.next;
        s.next = null;
        return head;
    }
}