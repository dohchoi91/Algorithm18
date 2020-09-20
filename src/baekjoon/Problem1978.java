package baekjoon;

import java.util.Scanner;

/**
 * 소수찾기 
 * https://www.acmicpc.net/problem/1978
 */
public class Problem1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int count = 0;
		for (int i = 0; i < num; i++) {
			int n = sc.nextInt();
			count = findDecimal(n) ? count + 1: count; 
		}
		
		System.out.println(count);
	}

	private static boolean findDecimal(int n) {
		boolean result = true;
		if (n == 1) {
			result = false;
		} else if (n == 2) {
			result = true;
		} else {
			int maxIndex = (int) (Math.sqrt(n) + 1);
			for (int i = 2; i <= maxIndex; i++) {
				if (n % i == 0) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
}
