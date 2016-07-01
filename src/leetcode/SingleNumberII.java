package leetcode;

import java.util.HashMap;
import java.util.Map;

/* Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {

	public int singleNumber(int[] A) {
		// an int has 32 bits
		int[] bits = new int[32];
		for (int i = 0; i < bits.length; i++) {
			bits[i] = 0;
		}
		// for each bit
		for (int i = 0; i < bits.length; i++) {
			for (int a : A) {
				// check the i-th bit for each element
				int bit = ((a >> i) & 1);
				if (bit > 0)
					bits[i]++;
			}
			bits[i] = bits[i] % 3;
		}
		int ans = 0;
		for (int i = 0; i < bits.length; i++) {
			ans |= (bits[i] << (i));
		}
		return ans;
	}
	
	public int singleNumber2(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < len; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                int n = map.get(nums[i]);
                map.put(nums[i],n+1);
            }
        }
        len = map.size();
        int result = 0;
        for(int n : map.keySet()){
            if(map.get(n) == 1){
                result = n;
                break;
            }
               
        }
         return result;
    }
	
}
