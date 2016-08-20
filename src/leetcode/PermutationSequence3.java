package leetcode;

import java.util.ArrayList;
import java.util.List;

/* The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
/* 数学的解法，适用度不高，仅限于这题，了解一下吧。
 题目告诉我们：对于n个数可以有n!种排列；那么n-1个数就有(n-1)!种排列。

 那么对于n位数来说，如果除去最高位不看，后面的n-1位就有 (n-1)!种排列。

 所以，还是对于n位数来说，每一个不同的最高位数，后面可以拼接(n-1)!种排列。

 所以你就可以看成是按照每组(n-1)!个这样分组。 
 利用 k/(n-1)! 可以取得最高位在数列中的index。这样第k个排列的最高位就能从数列中的index位取得，此时还要把这个数从数列中删除。
 然后，新的k就可以有k%(n-1)!获得。（恕我愚笨，现在也没想明白为啥要这么更新k~~）

 循环n次即可。 同时，为了可以跟数组坐标对其，令k先--。
 */
public class PermutationSequence3 {
	public static String getPermutation(int n, int k) {
		k--;
		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			numList.add(i);
		int factorial = 1;
		for (int i = 2; i < n; i++)
			factorial *= i;

		StringBuilder res = new StringBuilder();
		int times = n - 1;
		while (times >= 0) {
			int indexList = k / factorial;
			res.append(numList.get(indexList));
			numList.remove(indexList);

			k = k % factorial;
			if (times > 0)
				factorial = factorial / times;
			times--;
		}
		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println(getPermutation(8, 8590));
	}
}
