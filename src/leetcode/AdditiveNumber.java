package leetcode;

/* Additive number is a positive integer whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * Given a string represents an integer, write a function to determine if it's an additive number.
 * Follow up:
 * How would you handle overflow for very large input integers?
 */

/*	这道题是判断一个数是不是“可加数”，题意比较明了，就不复述了。
 首先我写了一个函数private boolean check(String num, String first, String second)，用来判断以first 和 second开始的数num是不是可加数
 接着就是遍历所有的first和second可能，要注意，除去first和second之外剩下的字符串长度一定要大于first和second中的较大者，
 所以first 、second最大是num长度的一半。
 刚开始为了避免int会溢出，我采用了BigInteger来进行加法，不过这拖累了速度，需要10ms，
 后来我准备分段，很大的时候用BigInteger，小的时候用Long，
 不过在分段之前用Long型试了下也可以Accept，而且时间仅仅需要2ms，就不分段了吧~。代码如下
 */
public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		int len = num.length();
		int valid = len / 2;
		for (int i = 1; i <= valid; i++) {
			for (int j = 1; j <= valid; j++) {
				if ((len - i - j) >= Math.max(i, j)) {
					if (check(num, num.substring(0, i), num.substring(i, i + j))) {
						return true;
					} else {
						continue;
					}
				} else {
					break;
				}
			}
		}
		return false;
	}

	private boolean check(String num, String first, String second) {
		long addFir = Long.parseLong(first);
		long addSec = Long.parseLong(second);
		long addThi = addFir + addSec;
		StringBuilder str = new StringBuilder("");
		str.append(addFir).append(addSec).append(addThi);
		while (num.startsWith(str.toString())) {
			if (num.length() == str.length()) {
				return true;
			}
			addFir = addSec;
			addSec = addThi;
			addThi = addFir + addSec;
			str = str.append(addThi);
		}
		return false;
	}
}