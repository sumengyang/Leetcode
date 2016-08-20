package leetcode;

/* Given a collection of numbers, return all possible permutations.
 * For example, 
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
/* We can recursively solve this problem. Swap each element with each element after it.
 */
/*对于第k层节点来说，就是交换固定了前面 k-1 位，然后分别 swap(k,k), swap(k, k+1) , swap(k, k+2) ...
 例如上图中的第三层，固定了第一位（即2），然后分别交换第1，1位，1，2位，1，3位*/

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permute(num, 0, result);
		return result;
	}

	public void permute(int[] num, int start, List<List<Integer>> result) {
		if (start >= num.length) { //终止条件，递归到末尾节点是，将数组转化为链表
			List<Integer> item = convertArrayToList(num);
			result.add(item);
			return;
		}
		for (int j = start; j < num.length; j++) {
			swap(num, start, j);//交换
			permute(num, start + 1, result);//交换后子代递归
			swap(num, start, j);//恢复到交换前的初始状态，以便于得出下一次的交换结果
		}
	}

	private List<Integer> convertArrayToList(int[] num) {//数组变链表
		List<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++)
			item.add(num[h]);
		return item;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
