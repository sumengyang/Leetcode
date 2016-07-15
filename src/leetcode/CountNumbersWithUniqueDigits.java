package leetcode;
/*
 * 	这道题让我们找一个范围内的各位上不相同的数字，比如123就是各位不相同的数字，
	而11,121,222就不是这样的数字。那么我们根据提示中的最后一条可以知道，一位数
	的满足要求的数字是10个(0到9)，二位数的满足题意的是81个，[10 - 99]这90个数
	字中去掉[11,22,33,44,55,66,77,88,99]这9个数字，还剩81个。
	通项公式为f(k) = 9 * 9 * 8 * ... (9 - k + 2)，
	那么我们就可以根据n的大小，把[1, n]区间位数通过通项公式算出来累加起来即可
*/

public class CountNumbersWithUniqueDigits {

	public int countNumbersWithUniqueDigits(int n){
		if(n ==0)
			return 1;
		int result = 0;
		for(int i = 1; i <= n; i++){
			result += count(i);
		}		
		return result;
	}
	
	private int count(int k){
		if(k == 1)
			return 10;
		int res = 1;
		for(int i = 9; i >= 11-k; i--)
			res *= i;
		return res*9;
	}
	
	public static void main(String[] args) {
		CountNumbersWithUniqueDigits cn = new CountNumbersWithUniqueDigits();
		for(int i = 0; i <5; i++){
			int t = cn.countNumbersWithUniqueDigits(i);
			System.out.println(t);
		}
	}

}
