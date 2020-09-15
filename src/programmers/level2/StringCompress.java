package programmers.level2;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
/**
 * 문자열 압축 (2020 KAKAO BLIND RECRUITMENT)
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 * [포인트]
 * 1. 자르는 조건 이해
 */
public class StringCompress {
	public int solution(String s) {
		int answer = s.length();
		
		StringBuilder stb = new StringBuilder(); 
		for (int i = 1; i < (s.length() / 2) + 1; i++) {
			stb.setLength(0);
			int aggCount = 1;
			
			String prev = s.substring(0, i);
			
			for (int j = i; j < s.length(); j+=i) {
				String extract = (j + i <= s.length()) ? s.substring(j, j + i) : s.substring(j, s.length());
				
				if (extract.equals(prev)) {
					aggCount++;
				} else {
					if (aggCount > 1) {
						stb.append(aggCount);
						aggCount = 1;
					} 
					stb.append(prev);
				}
				prev = extract;
			}
			
			if (aggCount > 1) {
				stb.append(aggCount);
				aggCount = 1;
			} 
			stb.append(prev);
			answer =  (stb.length() < answer) ? stb.length() : answer;
		}
		return answer;
	}
	
	@Test
	void test1() {
		assertEquals(7, solution("aabbaccc"));
	}
	@Test
	void test2() {
		assertEquals(9, solution("ababcdcdababcdcd"));
	}
	@Test
	void test3() {
		assertEquals(8, solution("abcabcdede"));
	}
	@Test
	void test4() {
		assertEquals(14, solution("abcabcabcabcdededededede"));
	}
	@Test
	void test5() {
		assertEquals(17, solution("xababcdcdababcdcd"));
	}
}
