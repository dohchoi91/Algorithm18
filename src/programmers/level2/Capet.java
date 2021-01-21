package programmers.level2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
/**
 * 카펫
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 * [포인트]
 * 1. 약수
 * 2. 테두리(=brown)에 대한 계산 산정법 추출 
 */
public class Capet {
	
	// 약수 구하기
	private List<Integer> getDivisor(int num) {
		List<Integer> results = new ArrayList<>();

		int len = (int) (Math.sqrt(num) + 1);

		for (int i = 2; i < len; i++) {
			if (num % i == 0) {
				results.add(i);
			}
		}
		return results;
	}
	
	public int[] solution(int brown, int yellow) {

		int[] answer = new int[2];
		int sum = brown + yellow;
		List<Integer> divisors = getDivisor(sum);

		for (int i = 0; i < divisors.size(); i++) {
			int height = divisors.get(i);
			int width = sum / divisors.get(i);
			
			// 위아래 너비 합 + 좌우 높이 합 - 공통 모서리
			//int calc = (width * 2) + ((height * 2) - 4);
			int calc = (((width + height) * 2) - 4);
			
			if (brown == calc) {
				answer[0] = width;
				answer[1] = height;
				break;
			}
		}
		return answer;
	}



	@Test
	void test1() {
		assertArrayEquals(new int[] { 4, 3 }, solution(10, 2));
	}

	@Test
	void test2() {
		assertArrayEquals(new int[] { 3, 3 }, solution(8, 1));
	}

	@Test
	void test3() {
		assertArrayEquals(new int[] { 8, 6 }, solution(24, 24));
	}
}
