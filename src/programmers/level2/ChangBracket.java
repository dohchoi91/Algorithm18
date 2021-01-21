package programmers.level2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


/**
 * 괄호 변환 (2020 KAKAO BLIND RECRUITMENT)
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 * 
 */
public class ChangBracket {
	private boolean chkRightBracket(String p) {
		boolean result = true;
		
		char[] brackets = p.toCharArray();
		int count = 0;
		for (int i = 0; i < brackets.length; i++) {
			if (brackets[i] == '(') {
				count++;
			} else {
				if (count == 0) {
					result = false;
					break;
				}
				count--;
			}
		}
		if (count != 0) {
			result = false;
		}
		return result;
	}
	
	public String solution(String p) {
		if (p.equals("") ||  chkRightBracket(p)) {
			return p;
		}
		
		char[] brackets = p.toCharArray();
		
		// 균형 잡힌 문자열 추출
		String w = "";
		String v = "";
		
		int sum = 0;
		for (int i = 0; i < brackets.length; i++) {
			int count = (brackets[i] == '(') ? -1 : 1;
			sum += count;
			if (sum == 0) {
				w = p.substring(0, i+1);
				v = p.substring(i + 1, brackets.length);
				break;
			}
		}
		
		if (chkRightBracket(w)) {
			// v에 대한 재귀
			return w + solution(v);
		} else {
			StringBuilder stb  = new StringBuilder();
			stb.append("(");
			stb.append(solution(v)); // v재귀 결과 추가
			stb.append(")");
			
			char[] wLetters = w.toCharArray();
			for (int i = 1; i < wLetters.length -1; i++) {
				char convert = (wLetters[i] == '(') ? ')' : '(';
				stb.append(convert);
			}
			return stb.toString();
		}
	}

	@Test
	void test1() {
		assertEquals("()(()())()", solution("()(()())()"));
	}
	@Test
	@Disabled
	void test2() {
		assertEquals("()", solution(")("));
	}

	@Test
	void test3() {
		assertEquals("()(())()", solution("()))((()"));
	}
	@Test
	void test4() {
		assertEquals("()()", solution("))(("));
	}

}
