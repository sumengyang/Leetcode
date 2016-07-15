package leetcode;
/* Given an integer, write a function to determine if it is a power of two
 * 判断一个数是否是2的幂，判断方法主要依据2的N次幂的特点：仅有首位为1，其余各位都为0.
 */
public class PowerofFour2 {
	public boolean isPowerOfTwo(int n) {
		if (n == 1)
			return true;
		if (n == 0)
			return false;
		while (n != 1) {
			if ((n & 1) != 0)
				return false;
			n = n >> 2;
		}
		return true;
	}
}
