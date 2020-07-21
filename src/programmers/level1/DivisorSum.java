package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/*
 * 약수의 합
 * https://programmers.co.kr/learn/courses/30/lessons/12928?language=java
 * [포인트]
 * 1. 범위 체크
 * 2. 굳이...
 */
public class DivisorSum {
	public int solution(int n) {
		int answer = 0;
		Map<Integer, Boolean> map = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {

			if (map.get(i) != null) {
				break;
			}
			
			if (n % i == 0) {
				int divide = n / i; 
				answer += (i  + divide);
				map.put(divide, true);
				
				if (i == divide) {
					answer -= divide;
					break;
				}
			}
		}
		return answer;
	}

	@Test
	void test1() {
		assertEquals(28, solution(12));
	}

	@Test
	void test2() {
		assertEquals(6, solution(5));
	}
	@Test
	void test3() {
		assertEquals(0, solution(0));
	}
	@Test
	void test4() {
		assertEquals(1, solution(1));
	}
}
