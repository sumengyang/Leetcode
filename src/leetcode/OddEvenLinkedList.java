package leetcode;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {// 元素个数<3，直接返回头
			return head;
		}

		ListNode even = head.next, odd = head, evenHead = head.next;

		while (even != null && even.next != null) { // 元素个数>=3&&循环能继续(even.next有值)
			odd.next = even.next; // odd元素指针指向even的下一个元素
			odd = odd.next; // odd指针后移
			even.next = odd.next; // even元素指向odd的下一个元素
			even = even.next; // even指针后移
		}
		odd.next = evenHead;// 对接odd尾和even的头
		return head;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}
}
