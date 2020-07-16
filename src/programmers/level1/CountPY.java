package programmers.level1;
/**
 * 문자열 내 p와 y의 개수
 * https://programmers.co.kr/learn/courses/30/lessons/12916
 */
public class CountPY {
	boolean solution(String s) {
		int result = 0;
		char[] letters = s.toUpperCase().toCharArray();
		for (int i = 0; i < letters.length; i++) {
			switch (letters[i]) {
				case 'P': result++; break;
				case 'Y': result--; break;
			}
		}
		return (result == 0);
	}
}
