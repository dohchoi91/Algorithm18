package programmers.level2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 08/05 -> Fail
 * 08/10 -> Fail
 * [포인트]
 * 1. 시간의 흐름과 다리의 길이에 대해서 생각.
 * 2. 대기열의  조건 처리, 무게에 대한  조건처리.
 */
public class TruckPassing {
	public int solution(int bridge_length, int weight, int[] truck_weights) {

		int second = 1;
		int sum = 0;
		int idx = 0;
		boolean next = true;

		Queue<Integer> onBridge = new LinkedList<>();
		int finish = 0;

		while (finish < truck_weights.length) {
			if (next && sum + truck_weights[idx] <= weight) {
				sum += truck_weights[idx];
				onBridge.add(truck_weights[idx]);

				if (++idx >= truck_weights.length) {
					next = false;
				}
			} else {
				onBridge.add(0);
			}

			if (onBridge.size() == bridge_length) {
				int element = onBridge.poll();
				if (element > 0) {
					sum -= element;
					finish++;
				}
			}
			second++;
		}
		return second;
	}

	@Test
	void test1() {
		assertEquals(8, solution(2, 10, new int[] { 7, 4, 5, 6 }));
	}

	@Test
	void test2() {
		assertEquals(101, solution(100, 100, new int[] { 10 }));
	}

	@Test
	void test3() {
		assertEquals(110, solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }));
	}

	@Test
	void test4() {
		assertEquals(14, solution(5, 5, new int[] { 1, 1, 1, 1, 1, 2, 2 }));
	}

	@Test
	void test5() {
		assertEquals(10, solution(3, 1, new int[] { 1, 1, 1 }));
	}

	@Test
	void test6() {
		assertEquals(18, solution(7, 7, new int[] { 1, 1, 1, 1, 1, 3, 3 }));
	}
}
