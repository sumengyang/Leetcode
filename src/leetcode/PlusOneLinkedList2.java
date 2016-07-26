package leetcode;

/*	
 * 	Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Input:
 1->2->3
 Output:
 1->2->4

 方法：两次翻转链表法
 问题矛盾点在于进位的时候，需要往前，但是linkedlist只能往后访问，不能往前。
 直接的就是反转链表，让最低位变成前面，这样做加法很容易，算完后再反转回来。

 注意的地方是：
 如果全部是999，算到最后的时候需要加一个node，怎么加这个一node就需要用一个变量每次循环的时候都保持住前面的一个node，
 这样最后加入1的时候，可以连接上。
 */

public class PlusOneLinkedList2 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(9);
		ListNode l3 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;

		PlusOneLinkedList2 plusone = new PlusOneLinkedList2();
		plusone.plusOne(l1);

		System.out.println(l1.value);
		System.out.println(l2.value);
		System.out.println(l3.value);
	}

	public ListNode plusOne(ListNode head) {
		if (head == null)
			return null;
		ListNode newHead = reverseLinkedList(head);
		ListNode node = newHead;
		ListNode pre = node;
		int flag = 1;

		while (node != null) {
			pre = node;
			int sum = node.value + flag;
			node.value = sum % 10;
			flag = sum / 10;
			if (flag == 0)
				break;
			node = node.next;
		}
		if (flag != 0)
			pre.next = new ListNode(1);

		return reverseLinkedList(newHead);
	}

	private ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dump = new ListNode(0);
		dump.next = head;

		ListNode pre = dump.next;
		while (pre.next != null) {
			ListNode cur = pre.next;
			pre.next = cur.next;
			cur.next = dump.next;
			dump.next = cur;
		}

		return dump.next;
	}

	static class ListNode {
		int value;
		ListNode next;

		public ListNode(int value) {
			this.value = value;
		}
	}
}
