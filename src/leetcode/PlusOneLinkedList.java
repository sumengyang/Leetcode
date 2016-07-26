package leetcode;

import leetcode.PlusOneLinkedList2.ListNode;
/*	
 * 	Given a non-negative number represented as a singly linked list of digits, plus one to the number.
	The digits are stored such that the most significant digit is at the head of the list.
	
	Example:
	Input:
		1->2->3
	Output:
		1->2->4
		
	方法：从左往右搜索，搜到最后一个！=9的node
	如果没有这个node，表明全部为9，则在前面加一个1的node，所有的node值变成0. 
	如果搜到了这个node，把这个node的值+1，然后把后面所有的是9的node，变成0.
*/

public class PlusOneLinkedList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(7);
		ListNode l3 = new ListNode(0);
		l1.next = l2;
		l2.next = l3;

		PlusOneLinkedList plusone = new PlusOneLinkedList();
		plusone.plusOne(l1);

		System.out.println(l1.value);
		System.out.println(l2.value);
		System.out.println(l3.value);
	}
	
	
	public ListNode plusOne(ListNode head) {
		if(head == null)
			return null;
		ListNode node = head;
		ListNode notNine = null;
		while(node != null){
			if(node.value != 9)
				notNine = node;
			node = node.next;
		}
		
		if(notNine == null){
			ListNode newHead = new ListNode(1);
			newHead.next = head;
			node = head;
			while(node != null){
				node.value = 0;
				node = node.next;
			}
			return newHead;
		}
		else{
			notNine.value = notNine.value + 1;
			node = notNine.next;
			while(node != null){
				node.value = 0;
				node = node.next;
			}
			return head;
		}
		
	}
	
	
	static class ListNode{
		int value;
		ListNode next;
		public ListNode(int value){
			this.value = value;
		}
	}
}
