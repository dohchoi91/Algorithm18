package programmers.level1;

/*
 * 수박수박수박수박수박수
 * https://programmers.co.kr/learn/courses/30/lessons/12922
 * 
 */
public class Watermelon {
	public String solution(int n) {
		StringBuilder stb = new StringBuilder();

		for (int i = 0; i < (n / 2); i++) {
			stb.append("수박");
		}

		if (n % 2 == 1) {
			stb.append("수");
		}

		return stb.toString();
	}
}
