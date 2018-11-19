package List_leetCode;


public class DetectCycle_142 {
	public static ListNode detectCycle(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow) {
				break;
			}
		}
		if(fast == null || fast.next == null) {
			return null;
		}else {
			fast = head;
			while(fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		return fast;
	}
}
