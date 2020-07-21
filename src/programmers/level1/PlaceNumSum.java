package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
 * 자릿수 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/12931?language=java
 * [포인트]
 * 1. 10에 대한 나머지 추가 및 나눠서 크기 줄이기
 * 2. 문자열 변환 및 한자리씩 변환 (java8 활용)
 */
public class PlaceNumSum {
	public int solution(int n) {
//				
//		while (n != 0) {
//            answer += n % 10;
//            n /= 10;
//      }
		int answer = Arrays.stream(String.valueOf(n).split("")).mapToInt(s -> Integer.parseInt(s)).sum();
		return answer;
	}
	
	@Test
	void test1() {
		assertEquals(6, solution(123));
	}
	
	@Test
	void test2() {
		assertEquals(24, solution(987));
	}
}
