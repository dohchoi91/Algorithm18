package base;

/**
 * 피보나치 수열 
 * F(n) = F(n-1) + F(n-2) 
 * 재귀함수 풀이
 */
public class Fibonacci {
	
	// 피보나치 수열 총합
	static int totalSum = 0;
	
	public static void main(String[] args) {
		int result = fib(4);
		System.out.println(result);
		System.out.println(totalSum);
	}

	private static int fib(int i) {
		int result = 0;
		if (i == 1 || i == 2) {
			result = 1;
		} else {
			result = fib(i - 2) + fib(i - 1);
		}
		totalSum += result;
		return result;
	}
}
