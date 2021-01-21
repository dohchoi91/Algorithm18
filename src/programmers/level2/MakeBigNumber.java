package programmers.level2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * 큰 수 만들기 https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class MakeBigNumber {
	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		
//		char[] ch = number.toCharArray();
//		int[] numberArray = new int[ch.length];
//		for (int i = 0; i < numberArray.length; i++) {
//			numberArray[i] = (int)ch[i] - 48;
//		}
		int[] numberArray = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
		
		int count = numberArray.length - k - 1;
		int idx = -1;
		
		while (count >= 0) {
			int max = -1;
			for (int i = idx + 1; i < numberArray.length - count; i++) {
				if (numberArray[i] > max) {
					max = numberArray[i];
					idx = i;
				}
			}
			answer.append(max);
			count --;
		}
		return answer.toString();
	}

	@Test
	void test1() {
		assertEquals("94", solution("1924", 2));
	}

	@Test
	void test2() {
		assertEquals("3234", solution("1231234", 3));
	}

	@Test
	void test3() {
		assertEquals("775841", solution("4177252841", 4));
	}
}
