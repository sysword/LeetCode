package List_leetCode;

import java.util.HashMap;

public class CopyRandomList_138 {
	public static RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) {
			return null;
		}
		RandomListNode cur = head;
		RandomListNode next = null;
		while(cur != null) {
			next = cur.next;
			RandomListNode newNode = new RandomListNode(cur.val);
			cur.next = newNode;
			newNode.next = next;
			cur = next;
		}
		
		cur = head;

		while(cur != null) {
			if(cur.random != null) {
				cur.next.random = cur.random.next;
			}else {
				cur.next.random = null;
			}
			cur = cur.next.next;
		}
		cur = head;
		RandomListNode newHead = cur.next;
		while(cur != null) {
			//System.out.println(cur.val);
			next = cur.next;
			cur.next = next.next;
			if(next.next != null) {
				next.next = next.next.next;
			}else {
				next.next = null;
			}
			cur = cur.next;
		}
		return newHead;
	}
	public static RandomListNode copyRandomList2(RandomListNode head) {
		if(head == null) {
			return null;
		}
		HashMap<RandomListNode, Integer> map = new HashMap<>();
		HashMap<Integer, RandomListNode> newMap = new HashMap<>();
		RandomListNode cur = head;
		int times = 0;
		RandomListNode newPre = null;
		while(cur != null) {
			RandomListNode newNode = new RandomListNode(cur.val);
			map.put(cur, times);
			newMap.put(times++, newNode);
			if(newPre == null) {
				newPre = newNode;
			}else {
				newPre.next = newNode;
				newPre = newNode;
			}
			cur = cur.next;
		}
		cur = head;
		times = 0;
		while(cur != null) {
			newMap.get(times++).random = cur.random == null ? null : newMap.get(map.get(cur.random));
			cur = cur.next;
		}		
		return newMap.get(0);
	}
	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);
		RandomListNode n6 = new RandomListNode(6);
		n1.next = n2;
		n1.random = n3;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		n2.random = n2;
		n3.random = n1;
		n4.random = n6;
		n5.random = n3;
		n6.random = n5;
		RandomListNode head = copyRandomList2(n1);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
