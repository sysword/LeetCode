package List_leetCode;

public class MergeTwoLists_21 {
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {
		ListNode mergerHead = new ListNode(0);
		ListNode temp = mergerHead;
		while(l1 != null && l2 != null) {
			if(l1.val > l2.val) {
				temp.next = l2;
				l2 = l2.next;
			}else {
				temp.next = l1;
				l1 = l1.next;
			}
			temp = temp.next;
		}
		if(l1 != null) {
			temp.next = l1;
		}
		if(l2 != null) {
			temp.next = l2;
		}
		return mergerHead.next;
	}
}
