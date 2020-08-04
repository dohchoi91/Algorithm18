package programmers.level2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 주식 가격 
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * [포인트]
 * 1. 가격이 떨어지지 않은 기간 (= 몇 초 동안 유지되는지)
 */
public class StockPrice {
	public int[] solution(int[] prices) {
		int[] anwser = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			int count = 0;
			for (int j = i + 1; j < prices.length; j++) {
				count++;
				if (prices[i] > prices[j]) {
					break;
				}
			}
			anwser[i] = count;
		}

		return anwser;
	}

	@Test
	void test1() {
		assertArrayEquals(new int[] { 4, 3, 1, 1, 0 }, solution(new int[] { 1, 2, 3, 2, 3 }));
	}
}
