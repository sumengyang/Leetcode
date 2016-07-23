package leetcode;

/* Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class KthLargestElementinanArray2 {
	// test case [2, 1], 1
	public int findKthLargest(int[] nums, int k) {
		return findK(nums, nums.length - k, 0, nums.length - 1);
	}

	private int findK(int[] nums, int k, int i, int j) {
		if (i >= j)
			return nums[i];
		int m = partition(nums, i, j);
		if (m == k)
			return nums[m];
		else if (m < k) {
			return findK(nums, k, m + 1, j);
		} else {
			return findK(nums, k, i, m - 1);
		}
	}

	private int partition(int[] nums, int i, int j) {
		int x = nums[i];
		int m = i;
		int n = i + 1;

		while (n <= j) {
			if (nums[n] < x) {
				swap(nums, ++m, n);
			}
			++n;
		}
		swap(nums, i, m);
		return m;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}