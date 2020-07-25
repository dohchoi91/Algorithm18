package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
 * 콜라츠 추측
 * https://programmers.co.kr/learn/courses/30/lessons/12943
 * [포인트]
 * 1. int -> long 변경 할 필요성.
 * 2. 처음부터 1이 들어오는 경우 생각할것.
 */
public class KolatzGuess {
	public int solution(int num) {
		int answer = (num == 1) ? 0 : -1;
		if (answer != 0) {
			long targetNum = num;
			for (int i = 1; i <= 500; i++) {
				targetNum = (targetNum % 2 == 0) ? targetNum / 2 : (targetNum * 3) + 1; 
				if (targetNum == 1) {
					answer = i;
					break;
				}
			}
		}
		return answer;
	}

	@Test
	void test1() {
		assertEquals(8, solution(6));
	}

	@Test
	void test2() {
		assertEquals(4, solution(16));
	}

	@Test
	void test3() {
		assertEquals(-1, solution(626331));
	}

	@Test
	void test4() {
		assertEquals(0, solution(1));
	}
}
