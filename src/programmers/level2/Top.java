package programmers.level2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * 탑
 * https://programmers.co.kr/learn/courses/30/lessons/42588
 */
public class Top {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

		int start = heights.length - 1;

		for (int i = start; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}

		return answer;
	}

	@Test
	void test1() {
		assertArrayEquals(new int[] { 0, 0, 2, 2, 4 }, solution(new int[] { 6, 9, 5, 7, 4 }));
	}

	@Test
	void test2() {
		assertArrayEquals(new int[] { 0, 0, 0, 3, 3, 3, 6 }, solution(new int[] { 3, 9, 9, 3, 5, 7, 2 }));
	}

	@Test
	void test3() {
		assertArrayEquals(new int[] { 0, 0, 2, 0, 0, 5, 6 }, solution(new int[] { 1, 5, 3, 6, 7, 6, 5 }));
	}
}
