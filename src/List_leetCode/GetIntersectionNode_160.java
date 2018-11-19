package List_leetCode;

import java.util.HashSet;

public class GetIntersectionNode_160 {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode result = null;
		HashSet<ListNode> hashSet = new HashSet<>();
		while(headA != null) {
			hashSet.add(headA);
			headA = headA.next;
		}
		while(headB != null) {
			if(hashSet.contains(headB)) {
				result = headB;
				break;
			}else {
				headB = headB.next;
			}
		}
		return result;
	}
	
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		ListNode result = null;
		ListNode curA = headA;
		ListNode curB = headB;
		int lenA = 0;
		int lenB = 0;
		while(headA != null) {
			lenA++;
			headA = headA.next;
		}
		while(headB != null) {
			lenB++;
			headB = headB.next;
		}
		int distance = 0;
		if(lenA >= lenB) {
			distance = lenA - lenB;
			for(int i=0;i<distance&&curA!=null;i++) {
				curA = curA.next;
			}
		}else {
			distance = lenB - lenA;
			for(int i=0; i<distance&&curB!=null;i++) {
				curB = curB.next;
			}
		}
		while(curA != null && curB != null) {
			if(curA == curB) {
				result = curB;
				break;
			}else {
				curA = curA.next;
				curB = curB.next;
			}
		}
		return result;
	}
}
