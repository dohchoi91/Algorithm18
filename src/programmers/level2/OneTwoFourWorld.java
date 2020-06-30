package programmers.level2;

/*
 * 124 나라의 숫자 
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 * 
 * [포인트] 
 * 1. 재귀 함수
 * 2. 인덱스가 불일치 하는 부분 교정
 */

public class OneTwoFourWorld {
	public static String solution(int n) {
		int[] rem = { 1, 2, 4 };
		if (n > 3) {
			return solution((n - 1) / 3) + String.valueOf(rem[(n - 1) % 3]);
		}
		return String.valueOf(rem[(n - 1) % 3]);
	}

	public static void main(String args[]) {
		for (int i = 1; i <= 20; i++) {
			System.out.println(solution(i));
		}
	}
}
