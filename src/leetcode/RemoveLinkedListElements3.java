package leetcode;

/* Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements3 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode prev = new ListNode(0);
		prev.next = head;
		ListNode dummy = prev;

		while (head != null) {
			if (head.val == val) {
				prev.next = head.next;
				head = head.next;
			} else {
				head = head.next;
				prev = prev.next;
			}
		}
		return dummy.next;
	}
}
