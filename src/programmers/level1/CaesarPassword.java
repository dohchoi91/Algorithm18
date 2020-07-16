package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 시저 암호 
 * https://programmers.co.kr/learn/courses/30/lessons/12926?language=java
 * [포인트]
 * 1. 아스키코드의 이해
 * 2. 인덱스가 초과 할 경우 어떻게 처음 값으로  되돌릴지?
 */

public class CaesarPassword {
	
	final int UPPER_START = 65;
	final int UPPER_END = 90;
	final int LOWER_START = 97;
	final int LOWER_END = 122;
	
	public String solution(String s, int n) {
		char[] letters = s.toCharArray();
		String answer = "";
		
		for (int i = 0; i < letters.length; i++) {
			int intValue = (int) letters[i];
			int newIntValue = intValue + n;
			char newLetter = (char)(intValue);
			
			if (intValue >= UPPER_START && intValue <= UPPER_END) {
				newLetter = (newIntValue > UPPER_END) ? (char) ((newIntValue) % (UPPER_END + 1) + UPPER_START) : (char)newIntValue;
			} else if (intValue >= LOWER_START && intValue <= LOWER_END) {
				newLetter = (newIntValue > LOWER_END) ? (char) ((newIntValue) % (LOWER_END + 1)  + LOWER_START) : (char)newIntValue;
			}
			answer += newLetter;
		}

		return answer;
	}
	
	@Test
	@DisplayName("메인 테스트")
	public void main() {
		assertEquals("BC", solution("AB", 1));
		assertEquals("a", solution("z", 1));
		assertEquals("e F d", solution("a B z", 4));
	}

}
