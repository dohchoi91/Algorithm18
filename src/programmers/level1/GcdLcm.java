package programmers.level1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
 * 최대공약수, 최소공배수
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 * [포인트]
 * 1. 최대공약수, 최소 공배수의 특징 파악
 */
public class GcmLcm {
	public int[] solution(int n, int m) {
		int big = Math.max(n, m);
		int small = Math.min(n, m);
		int gcm = 1;
		
		// 시도 1 : 순차적으로 나누고 결과에 반영 그리고 리셋 후 다시 나누는 과정 
//		boolean isRun = true;
//		
//		while (isRun) {
//			for (int i = 2; i <= small; i++) {
//				if (small % i == 0 && big % i == 0) {
//					big /= i;
//					small /= i;
//					gcm *= i;
//					break;
//				}
//				 if (i == small) {
//					isRun = false;
//				}
//			}
//			if (small == 1) {
//				isRun = false;
//			}
//		}
//		int[] answer = { gcm, (gcm * big * small) };
		
		// 시도 2 : for문으로 순차적으로 증가 시키고 결과 반영
		for (int i = 2; i <= small; i++) {
			if (n % i == 0 && m % i == 0) {
				gcm = i;
			}
		}
		int[] answer = { gcm, (n * m / gcm) };
		
		
		return answer;
	}

	@Test
	void test1() {
		assertArrayEquals(new int[] { 3, 12 }, solution(3, 12));
	}

	@Test
	void test2() {
		assertArrayEquals(new int[] { 1, 10 }, solution(2, 5));
	}

}
