package programmers.level1;

/**
 * 문자열 다루기 기본
 * https://programmers.co.kr/learn/courses/30/lessons/12918
 * [포인트] 
 * 1. 다양한 방법이 존재. (정규표현식, 에러 유발, for문 체크)
 */

public class StringHandle {
	public boolean solution(String s) {
		boolean answer = false;
		if (s.length() == 4 || s.length() == 6) {
			try {
				Integer.parseInt(s);
				answer = true;
			} catch (Exception e) {
				answer = false;
			}
		}
		return answer;
	}
}
