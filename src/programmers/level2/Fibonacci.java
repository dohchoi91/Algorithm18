package programmers.level2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 피보나치 수열
 * https://programmers.co.kr/learn/courses/30/lessons/12945
 * [포인트]
 * 1. 1234567의 나머지 적용
 */
public class Fibonacci {
    public int solution(int n) {
		int answer = (n == 1) ? 0 : 1;
		int prev = 0;
		
		for (int i = 0; i < n - 1; i++) {
			int tmp = answer % 1234567;
			answer = (prev % 1234567) + (answer % 1234567);
			prev = tmp;
		}
		return answer % 1234567;
	}


	@Test
	void test1() {
		assertEquals(2, solution(3));
	}
	@Test
	void test2() {
		assertEquals(5, solution(5));
	}
	@Test
	void test3() {
		assertEquals(1, solution(2));
	}
	@Test
	void test4() {
		assertEquals(0, solution(1));
	}
	
}
