package leetcode;

/* Given an integer, write a function to determine if it is a power of two
 * 判断一个数是否是2的幂，判断方法主要依据2的N次幂的特点：仅有首位为1，其余各位都为0.
 */
public class PowerofTwo {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		while (n % 2 == 0) {
			n /= 2;
		}
		return n == 1 ? true : false;
	}
}
