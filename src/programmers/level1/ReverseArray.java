package programmers.level1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

// 자연수 뒤집어 배열로 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12932
public class ReverseArray {
	public int[] solution(long n) {
		// 시도 1
//		List<Long> list = new ArrayList<>();
//		while (n > 0) {
//			list.add(n % 10);
//			n /= 10;
//		}
//		int[] answer = new int[list.size()];
//		for (int i = 0; i < answer.length; i++) {
//			answer[i] = (int)((long)(list.get(i)));
//		}
		
		// 시도 2
		int[] answer = new int[String.valueOf(n).length()];
		int idx = 0;
		while (n > 0) {
			answer[idx++] = (int)(n % 10);
			n /= 10;
		}
		
		return answer;
	}

	@Test
	void test1() {
		assertArrayEquals(new int[] { 5, 4, 3, 2, 1 }, solution(12345));
	}
}
