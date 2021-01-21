package programmers.level1.kakao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * 2018 KAKAO BLIND RECRUITMENT : 비밀지도
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 */
public class SecretMap {

	public char[] binarayToRowChars(int n, String row) {
		StringBuilder stb = new StringBuilder();
		int diff = n - row.length();
		while (diff > 0) {
			stb.append("0");
			diff--;
		}
		stb.append(row);
		row = stb.toString();
		return row.toCharArray();
	}

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			char[] rowChars1 = binarayToRowChars(n, Integer.toBinaryString(arr1[i]));
			char[] rowChars2 = binarayToRowChars(n, Integer.toBinaryString(arr2[i]));

			StringBuilder stb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				String value = (rowChars1[j] == rowChars2[j] && rowChars1[j] != '1') ? " " : "#";
				stb.append(value);
			}
			answer[i] = stb.toString();
		}
		return answer;
	}

	@Test
	void test1() {
		assertArrayEquals(new String[] { "#####", "# # #", "### #", "#  ##", "#####" },
				solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] { 30, 1, 21, 17, 28 }));
	}
}
