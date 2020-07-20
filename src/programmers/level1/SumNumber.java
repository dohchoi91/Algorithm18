package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 두 정수 사이의 합
 * https://programmers.co.kr/learn/courses/30/lessons/12912?language=java
 * [포인트] 
 * 1. 규칙 찾기
 * 2. int, long에 데이터 표현 범위 정확히 파악
 */
public class SumNumber {
	public long solution(int a, int b) {
		long answer = 0;
		
		if (a == b) {
			answer = a;
		} else {
			// 큰수, 작은수 판정
			int big = (a > b) ? a : b;
			int small = (a > b) ? b : a;
			
			long sum = (a + b);
			int count = big - small + 1;
			int divide = count / 2;
			int mode = count % 2;
			
			answer = ((sum * divide) + (sum / 2 * mode));
		}
		return answer;
	}

	@Test
	public void test0() {
		assertEquals(0, solution(-10, 10));
	}

	@Test
	public void test1() {
		assertEquals(12, solution(3, 5));
	}

	@Test
	public void test2() {
		assertEquals(3, solution(3, 3));
	}

	@Test
	public void test3() {
		assertEquals(12, solution(5, 3));
	}
}
