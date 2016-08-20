package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LinkedListRandomNode {
    List<Integer> list = new ArrayList<Integer>();
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        ListNode node = head;
        while(node != null){
            list.add(node.val);
            node = node.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int i = rand.nextInt(list.size());
        return (int)list.get(i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */