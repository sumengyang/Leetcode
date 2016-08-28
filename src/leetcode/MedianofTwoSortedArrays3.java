package leetcode;

/* There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
/*
 复杂度:
 时间O(n) 空间O(1)

 思路:
 如果对时间复杂度没有要求，这个方法是实现起来最简单的，我们只需要从下往上依次数(n+m)/2个元素即可。
 由于两个数组都已经排序，我们可以使用两个指针指向数组“底部”，通过比较两个数组“底部”的元素大小来决定计哪一个元素，同时将其所在数组的指针“向上”移一位。
 为了方便处理总元素为偶数的情况，这里将找中位数变成找第k小的元素。

 注意:
 计数的循环是用来找到第k-1个元素的，最后return的时候再判断第k个元素是哪一个
 */
public class MedianofTwoSortedArrays3 {
	public double findMedianSortedArrays(int A[], int B[]) {
		int Alen = A.length;
		int Blen = B.length;
		int mid = (Alen + Blen) / 2;
		// odd and even
		if ((Alen + Blen) % 2 == 0) {
			return (findKth(A, B, mid - 1) + findKth(A, B, mid)) / 2;
		} else {
			return findKth(A, B, mid);
		}
	}

	public static int findKth(int[] a, int[] b, int k) {
		int p = 0, q = 0;
		// 在每次计数的循环中要先判断两个数组指针是否超界，在最后return之前也要判断一次
		for (int i = 0; i < k; i++) {
			if (p >= a.length && q < b.length)
				q++;
			else if (q > b.length && p < a.length)
				p++;
			else if (a[p] > b[q])
				q++;
			else
				p++;
		}
		if (p > a.length)
			return b[q];
		else if (q > b.length)
			return a[p];
		else
			return Math.min(a[p], b[q]);
	}
}