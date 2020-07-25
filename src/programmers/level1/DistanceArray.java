package programmers.level1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * x만큼 간격이 있는 n개의 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 */
public class DistanceArray {
	public long[] solution(long x, int n) {
		long[] answer = new long[n];
		for (int i = 1; i <= n; i++) {
			answer[i - 1] = i * x;
		}
		return answer;
	}

	@Test
	void test1() {
		assertArrayEquals(new long[] { 2, 4, 6, 8, 10 }, solution(2, 5));
	}

	@Test
	void test2() {
		assertArrayEquals(new long[] { 4, 8, 12 }, solution(4, 3));
	}

	@Test
	void test3() {
		assertArrayEquals(new long[] { -4, -8 }, solution(-4, 2));
	}
	@Test
	void test4() {
		assertArrayEquals(new long[] { 0, 0 }, solution(0, 2));
	}
	@Test
	void test5() {
		assertArrayEquals(new long[] { -10000000, -20000000 }, solution(-10000000, 2));
	}
	
	
}
