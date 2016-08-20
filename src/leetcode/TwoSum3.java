package leetcode;

import java.util.HashMap;
import java.util.Map;

/* Given an array of integers, find two numbers such that they add up to a specific target 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
/* Time complexity of this solution: O(n)
 */
public class TwoSum3 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			if (map.containsKey(target - x)) {
				int second = map.get(target - x);
//				if (i > second) {
//					int temp = i;
//					i = second;
//					second = temp;
//				}结果不必按大小返回
				res[0] = i;
				res[1] = second;
				return res;
			}
			map.put(x, i);
		}
		return res;
	}
}
