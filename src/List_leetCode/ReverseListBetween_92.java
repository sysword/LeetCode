package List_leetCode;

public class ReverseListBetween_92 {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null||m>=n||m<=0) {
			return head;
		}
		int times = n-m+1;
		ListNode result = head;
		ListNode pre_head = null;
		//找到要修改段的前驱结点，head变为要修改段的第一个节点
		while(head!=null&&(--m>0)) {
			pre_head = head;
			head = head.next;
		}
		
		ListNode reverse_tail = head;
		ListNode reverse_head = null;
		//将要修改段的节点都翻转，head变为修改段的后继
		while(head!=null&&(times>0)) {
			ListNode next = head.next;
			head.next = reverse_head;
			reverse_head = head;
			head = next;
			times--;
		}
		reverse_tail.next = head;
		if(pre_head==null) {
			return reverse_head;
		}else {
			pre_head.next = reverse_head;
		}
		return result;
	}
}
