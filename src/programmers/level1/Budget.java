package programmers.level1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * 예산 
 * https://programmers.co.kr/learn/courses/30/lessons/12982
 * [포인트]
 * 1. 지문 자체가 함정.
 * 2. 조합 문제가  아님.
 */
public class Budget {

	public int solution(int[] d, int budget) {
		Arrays.sort(d);

		int answer = 0;
		for (int i = 0; i < d.length; i++) {
			budget -= d[i];
			if (budget < 0)
				break;
			answer++;
		}
		return answer;
	}

	@Test
	void test1() {
		assertEquals(3, solution(new int[] { 1, 3, 2, 5, 4 }, 9));
	}

	@Test
	void test2() {
		assertEquals(4, solution(new int[] { 2, 2, 3, 3 }, 10));
	}

	@Test
	void test3() {
		assertEquals(3, solution(new int[] { 1, 7, 2, 4, 7 }, 9));
	}

}
