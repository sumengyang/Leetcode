package leetcode;

/* Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.Here are some examples. 
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
/* step 1 From right to left find the first number(partition number) which violate increasing trend
 *        If not exist, this is the last permutation. (in this problem just reverse the array)
 * step 2 From right to left find the first number(change number)which larger than partition number
 * step 3 Swap partition number and the change number
 * step 4 Reverse all the number on the right of partition index
 */
import java.util.*;

/*开始就没读懂题，后来终于找到一个说明白的解释。 

 * 首先要明白:什么是next permutation. 简单点说,如果输入的数字有大小的话,那么 next permutation就是下一个大于它并"最接近"它的全排列. 
 * 比如123, 下一个使用 这三个数字的排列就是132(213, 312虽然也是全排列,但是都比132大)
 * 如果这个全排列已经是最大的了(全部升序排列),那么它的next permutation就来一个 "头尾想接"(就是最小的数字): 
 * 比如321的排列已经是最大的了， 所以next permutation 就是把321完全反转成最小的123

 实现一般分下面四个步骤(对应图):

1. 从后往前找,找到第一个array[i] < array[i+1]的地方, 这个地方是整个字符串 最晚的"升序"的地方,而且在数字尾端,更改的话最容易做到"最接近".
 通过从后往前 逐个比较,我们发现8这个数字是一个分界线.8后面的数字都是降序的(也就是最大的了)
2. 我们如果直接把6和8一交换,肯定也会产生一个permutation,但是不是"最接近的",怎样 找到"最接近"的呢,
 就要从1到8后面这端寻找一个比6大,并且和6差距最小的(也就是从 后往前第一个比6大的数字),我们找到了是7
3. 7作为最佳选择,和6进行调换. 7后面肯定还是decrease的状态(也就是能组成的最大值)
 为了达到"最接近",我们在6变成7的情况下已经增长很多了.
4. 所以我们要把7后面的一系列 decrease的数组反转(也就是能组成的最小值)

 5-6-8-7-4-3-2-1
 变换为：
 5-7-1-2-3-4-6-8*/

public class NextPermutation {
	public void nextPermutation(int[] num) {
		if (num.length <= 1)
			return;
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				int j = 0;
				for (j = num.length - 1; j >= i; j--)
					if (num[i] < num[j])
						break;
				// swap the two numbers.
				swap(num, i, j);
				// sort the rest of arrays after the partition index.
				Arrays.sort(num, i + 1, num.length);
				return;
			}
		}
		// reverse the arrays if the last permutation
		for (int i = 0; i < num.length / 2; i++) {
			swap(num, i, num.length - 1 - i);
		}
		return;
	}

	private static void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
