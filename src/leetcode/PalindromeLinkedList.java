package leetcode;

/*
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

//1、遍历整个链表，将链表每个节点的值记录在数组中，再判断数组是不是一个回文数组，
//时间复杂度为O（n），但空间复杂度也为O（n），不满足空间复杂度要求。
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		ListNode p = head;
		ListNode q = head;
		int count = 0;

		while (q.next != null && q.next.next != null) {
			p = p.next;
			q = q.next.next;
			count++;
		}
		if (q.next != null)
			p = p.next;
		int right[] = new int[count + 1];
		int i = 0;
		while (p != null) {
			right[i] = p.val;
			p = p.next;
			i++;
		}
		while (count >= 0) {
			if (head.val != right[count])
				return false;
			count--;
			head = head.next;
		}
		return true;
	}
}
