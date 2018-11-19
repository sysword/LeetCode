package List_leetCode;


public class ReverseList_206 {
	public static ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while(head!=null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}
