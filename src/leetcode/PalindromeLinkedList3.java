package leetcode;

/*
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
/*
 * 3、反转链表法，将链表后半段原地翻转，再将前半段、后半段依次比较，判断是否相等，
	时间复杂度O（n），空间复杂度为O（1）满足题目要求。
	链表翻转可以参考LeetCode 206 Reverse Linked List的代码。
*/
public class PalindromeLinkedList3 {
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
        ListNode fast = head;
        
        if(fast == null || fast.next == null)
            return true;
            
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midNode = slow;
        ListNode firNode = slow.next;
        ListNode curNode = firNode.next;
        firNode.next = null;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = midNode.next;
            midNode.next = curNode;
            curNode = nextNode;
        }
        slow = head;
        fast = midNode.next;
        while(fast != null){
            if(fast.val != slow.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
	}
}
