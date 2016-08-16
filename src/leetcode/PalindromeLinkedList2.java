package leetcode;
/*2、利用栈先进后出的性质，将链表前半段压入栈中，再逐个弹出与链表后半段比较。
时间复杂度O（n），但仍然需要n/2的栈空间，空间复杂度为O（n）*/
public class PalindromeLinkedList2 {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		ListNode p = head;
		int count = 0;
		while (p != null) {
			count++;
			p = p.next;
		}
		int nums[] = new int[count];
		p = head;
		int i = 0;
		while (p != null) {
			nums[i++] = p.val;
		}
		for (int j = 0; j < count; j++) {
			if (nums[j] != nums[count - j - 1])
				return false;
		}
		return true;
	}
}
