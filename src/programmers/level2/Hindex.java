package programmers.level2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
/**
 * H-Index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 * [포인트]
 * 1. 전체 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값
 */
public class Hindex {

	public int solution(int[] citations) {
		Arrays.sort(citations);
		int hIndex = 0;
		
		for (int i = 0; i < citations.length; i++) {
			int idx = citations.length - i;
			if (citations[i] >= idx && i <= idx && hIndex < idx) {
				hIndex = idx;
			}
		}
		return hIndex;
	}

	@Test
	void test1() {
		assertEquals(3, solution(new int[] { 3, 0, 6, 1, 5 }));
	}

	@Test
	void test2() {
		assertEquals(4, solution(new int[] { 10, 8, 5, 4, 3 }));
	}

	@Test
	void test3() {
		assertEquals(3, solution(new int[] { 25, 8, 5, 3, 3 }));
	}
	
	@Test
	void test4() {
		assertEquals(4, solution(new int[] { 4, 4, 4, 5, 0, 1, 2, 3 }));
	}
	@Test
	void test5() {
		assertEquals(4, solution(new int[] { 10, 11, 12, 13 }));
	}
	@Test
	void test6() {
		assertEquals(3, solution(new int[] { 3, 0, 6, 1, 5 }));
	}
	@Test
	void test7() {
		assertEquals(0, solution(new int[] { 0, 0, 1, 1 }));
	}
	@Test
	void test8() {
		assertEquals(3, solution(new int[] {10, 9, 4, 1, 1}));
	}
	@Test
	void test9() {
		assertEquals(1, solution(new int[] {0, 1}));
	}
	@Test
	void test10() {
		assertEquals(0, solution(new int[] {0, 0 , 0, 0}));
	}
}
