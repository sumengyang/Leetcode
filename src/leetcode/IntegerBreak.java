package leetcode;

public class IntegerBreak {

	public static void main(String[] args) {

		int i = integerBreak(40);
		System.out.print(i);
	}
	public static int integerBreak(int n) {
        if(n == 2 || n == 3)
            return n-1;
        if(n == 4)
            return n;
        int result = 1;
        while(n > 4){
            result *= 3;
            n -= 3;
        }
        return result*n;
    }
}
