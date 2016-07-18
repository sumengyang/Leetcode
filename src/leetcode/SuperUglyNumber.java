package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*	Write a program to find the nth super ugly number.
	Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
	For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers
	given primes = [2, 7, 13, 19] of size 4.

	Note:
	(1) 1 is a super ugly number for any given primes.
	(2) The given numbers in primes are in ascending order.
	(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
*/
public class SuperUglyNumber {

	public static void main(String[] args) {
		int n = 12;
		int[] primes = {2,7,13,19};
		int result = nthSuperUglyNumber(n, primes);
		System.out.println(result);
	}
	public static int nthSuperUglyNumber(int n, int[] primes) {  
        int[] ugly_number = new int[n];  
        ugly_number[0] = 1;  
        PriorityQueue<Node> q = new PriorityQueue<Node>();  
        for (int i = 0; i < primes.length; i++)  
            q.add(new Node(0, primes[i], primes[i]));  
        for (int i = 1; i < n; i++) {  
            Node cur = q.peek();  
            ugly_number[i] = cur.val;  
            do {  
                cur = q.poll();  
                cur.val = ugly_number[++cur.index] * cur.prime;  
                q.add(cur);  
            } while (!q.isEmpty() && q.peek().val == ugly_number[i]);  
        }  
        return ugly_number[n-1];  
    }  
}
  
class Node implements Comparable<Node> {  
    int index;  
    int val;  
    int prime;  
  
    Node(int index, int val, int prime) {  
        this.val = val;  
        this.index = index;  
        this.prime = prime;  
    }  
  
    public int compareTo(Node x) {  
        return this.val > x.val ? 1 : -1;  
    }  
}  