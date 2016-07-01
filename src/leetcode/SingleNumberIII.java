package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/
public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i]))
				set.add(nums[i]);
			else {
				set.remove(nums[i]);
			}
		}
		Iterator<Integer> it = set.iterator();
		res[0] = it.next();
		res[1] = it.next();
		return res;
	}
	
	//哈哈 产生冲突了吧
	//上面的函数只检测两个单个的数字，而这个函数无论有多少单个的数字都可以得到
	public int[] singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        int len = nums.length;
        for(int i = 0; i < len;i++){
            if(!set.add(nums[i]))
                set.remove(nums[i]);
        }
        
        Iterator<Integer> itr = set.iterator();
        len = set.size();
        int[] single = new int[len];
        for(int i = 0; i < len; i++)
            single[i] = itr.next();
        
        return single;
    }
	
	
	
}
