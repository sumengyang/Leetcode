package leetcode;

/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {
	//这个用了除法
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		int res[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int index = i;
				product = 1;
				for (int j = 0; j < nums.length; j++) {
					if (j != i)
						product *= nums[j];
				}
				res[i] = product;
				return res;
			}
			product *= nums[i];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] != 0) {
				res[i] = product / nums[i];
			}
		}
		return res;
	}
	
	//用当前数把数组分了左右两个序列相乘
	public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        
        int[] result = new int[len];
        if(len < 2)
            return result;
        result[len-1] = 1;
        
        for(int i = len-2; i>=0; i--){
            result[i] = result[i+1] * nums[i+1]; 
        }
        
        int left = 1;
        for(int i = 0; i < len; i++){
            result[i] *= left;
            left *= nums[i];
        }

        return result;
    }
	
	
}
