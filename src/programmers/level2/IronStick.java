package programmers.level2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 쇠막대기 
 * https://programmers.co.kr/learn/courses/30/lessons/42585
 */
public class IronStick {
	public int solution(String arrangement) {
		char[] ch = arrangement.replace("()", "0").toCharArray();
		
		int answer = 0;
		int count = 0;
		
		for (int i = 0; i < ch.length; i++) {
			switch (ch[i]) {
			case '0':
				answer += count; 
				break;
			case '(':
				count++;
				break;
			case ')':
				count--;
				answer += 1; 
				break;
			}
		}
		return answer;
	}

	@Test
	void test1() {
		assertEquals(17, solution("()(((()())(())()))(())"));
	}
}
