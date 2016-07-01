package leetcode;

/*
 * 	Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 Example:
 Given a = 1 and b = 2, return 3.
 */

public class SumofTwoIntegers {
	public static int getSum(int a, int b) {
		int c = 0;
		while (b != 0) {
			c = a ^ b;
			b = (a & b) << 1;
			a = c;
		}
		return a;
	}

	public static int getSum2(int a, int b) {
	        int r = 0, c = 0, p = 1;
	        while ((a | b | c) != 0) {
	            if (((a ^ b ^ c) & 1) != 0)
	                r |= p;
	            p <<= 1;
	            c = (a & b | b & c | a & c) & 1;
	            a >>>= 1;
	            b >>>= 1;
	        }
	        return r;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSum(2, 2));
		System.out.println(getSum2(2, 2));
	}

}
