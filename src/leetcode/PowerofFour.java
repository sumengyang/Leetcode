package leetcode;

/* Given an integer, write a function to determine if it is a power of two
 * 判断一个数是否是4的幂，判断方法主要依据4的N次幂的特点
 */
public class PowerofFour {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		while (n % 4 == 0) {
			n = n >> 2;
		}
		return n == 1 ? true : false;
	}
}
