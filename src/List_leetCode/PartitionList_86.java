package List_leetCode;

public class PartitionList_86 {
	public static ListNode partitionList(ListNode head, int x) {
		if(head==null) {
			return null;
		}
		ListNode bigger_head = null ;
		ListNode bigger_tail = null ;
		ListNode equal_head = null ;
		ListNode equal_tail = null ;
		ListNode smaller_head = null ;
		ListNode smaller_tail = null ;
		while(head != null) {
			if(head.val > x) {
				if(bigger_head != null) {
					bigger_tail.next = head;
					bigger_tail = head;
				}else {
					bigger_head = head;
					bigger_tail = head;
				}
			}else if(head.val == x) {
				if(equal_head != null) {
					equal_tail.next = head;
					equal_tail = head;
				}else {
					equal_head = head;
					equal_tail = head;
				}
			}else {
				if(smaller_head != null) {
					smaller_tail.next = head;
					smaller_tail = head;
				}else {
					smaller_head = head;
					smaller_tail = head;
				}
			}
			head = head.next;
		}
		
		if(smaller_head != null) {
			if(equal_head != null) {
				smaller_tail.next = equal_head;
				equal_tail.next = bigger_head;
				bigger_tail.next = null;
				return smaller_head;
			}else {
				smaller_tail.next = bigger_head;
				return smaller_head;
			}
		}else {
			if(equal_head != null) {
				equal_tail.next = bigger_head;
				return equal_head;
			}else {
				return bigger_head;
			}
		}
	}
	
	public static ListNode partitionList2(ListNode head, int x) {
		ListNode less_head = new ListNode(0);
		ListNode more_head = new ListNode(0);
		ListNode less_tail = less_head;
		ListNode more_tail = more_head;
		while(head != null) {
			if(head.val > x) {
				more_tail.next = head;
				more_tail = head;
			}else {
				less_tail.next = head;
				less_tail = head;
			}
			head = head.next;
		}
		less_tail.next = more_head.next;
		more_tail.next = null;
		return less_head.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		ListNode curHead = partitionList(n1, 3);
		while(curHead != null) {
			System.out.print(curHead.val + " ");
			curHead = curHead.next;
		}
	}
}
