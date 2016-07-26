package leetcode;

/*
 * 	Given a linked list, remove the nth node from the end of list and return its head.

	For example,
   	Given linked list: 1->2->3->4->5, and n = 2.
   	After removing the second node from the end, the linked list becomes 1->2->3->5.

	Note:
	Given n will always be valid.
	Try to do this in one pass.
*/

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		ListNode second = head;
		if (head.next == null)
			return null;
		while (n != 0) {
			first = first.next;
			n--;
		}
		if (first == null)
			return head.next;
		while (first.next != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return head;
	}
}
