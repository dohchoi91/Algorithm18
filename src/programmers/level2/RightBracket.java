package programmers.level2;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 올바른 괄호
 * https://programmers.co.kr/learn/courses/30/lessons/12909
 * [포인트]
 * 괄호의 open, close의 특징 파악하기.
 */
public class RightBracket {
	
	// Stack
	boolean solution1(String s) {
		boolean answer = true;
		char[] brackets = s.toCharArray();
		
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < brackets.length; i++) {
			if (brackets[i] == '(') {
				stack.push(brackets[i]);
			} else {
				if (stack.isEmpty()) {
					answer = false;
					break;
				} else {
					stack.pop();
				}
			}
		}
		answer = (answer && stack.isEmpty());
		return answer;
	}
	
	// Stack 없이
	boolean solution2(String s) {
		boolean answer = true;
		char[] brackets = s.toCharArray();
		
		int count = 0;
		for (int i = 0; i < brackets.length; i++) {
			if (brackets[i] == '(') {
				count++;
			} else {
				if (count == 0) {
					answer = false;
					break;
				} else {
					count--;
				}
			}
		}
		answer = (answer && (count == 0));
		return answer;
	}
	@Test
	void test1() {
		assertEquals(true, solution1("()()"));
		assertEquals(true, solution2("()()"));
	}

	@Test
	void test2() {
		assertEquals(true, solution1("(())()"));
		assertEquals(true, solution2("(())()"));
	}

	@Test
	void test3() {
		assertEquals(false, solution1(")()("));
		assertEquals(false, solution2(")()("));
	}

	@Test
	void test4() {
		assertEquals(false, solution1("(()("));
		assertEquals(false, solution2("(()("));
	}
}
