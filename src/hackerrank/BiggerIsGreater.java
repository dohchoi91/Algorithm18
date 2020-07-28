package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Bigger is Greater
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem 
 * [포인트]
 * 1. 다음 순열
 */
public class BiggerIsGreater {

	static String biggerIsGreater(String w) {
		StringBuilder stb = new StringBuilder();
		
		char[] words = w.toCharArray();
		int n = words.length;
		int index = 0;
		
		// 인접한 수 중 가장 큰 수의 인덱스 찾기.
		for (int i = 1; i < n; i++) {
			if ((words[i - 1] < words[i]) && (index < i)) {
				index = i;
			}
		}
		
		if (index <= 0) { // 다음 순열 존재여부 체크
			stb.append("no answer");
		} else {
			int nextIndex = 0;
			// 다음에 올 수 찾기 (배열 나머지에서 (index - 1)x의 값보단 큰값 중 가장 작은값)
			for (int j = index; j < n; j++) {
				if ((words[index - 1] < words[j]) && nextIndex < j) {
					nextIndex = j;
				}
			}
			
			// index 이전의 값과 다음 index값의 자리를 교체
			char tmp = words[index - 1];
			words[index - 1] = words[nextIndex];
			words[nextIndex] = tmp;
			
			// index에서 다음 index - 1 까지 뒤집어 버린다.
			nextIndex = n - 1;
			while (index <= nextIndex) {
				tmp = words[index];
				words[index] = words[nextIndex];
				words[nextIndex] = tmp;
				index++;
				nextIndex--;
			}

			for (int i = 0; i < n; i++) {
				stb.append(words[i]);
			}
		}

		return stb.toString();
	}

	@Test
	void test1() {
		assertEquals("abdc", biggerIsGreater("abcd"));
	}
	@Test
	void test2() {
		assertEquals("no answer", biggerIsGreater("aa"));
	}
}
