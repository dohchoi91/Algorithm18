package programmers.level2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

/**
 * 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * 08/09 -> Fail
 * [포인트] 
 * 1. 우선순위 큐
 */
public class MoreSpicy {
	

	public int solution(int[] scoville, int K) {
		int result = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		boolean isExistExeedValue = false;
		
		for (int i = 0; i < scoville.length; i++) {
			if (scoville[i] < K) {
				pq.add(scoville[i]);
			} else {
				isExistExeedValue = true;
			} 
		}
		
		while(pq.size() > 1) {
			int newEl = pq.poll() + (pq.poll() * 2);
			
			if (newEl < K) {
				pq.add(newEl);	
			} else {
				isExistExeedValue = true;
			}
			result++;
		}
		
		if (pq.size() == 1 && isExistExeedValue) {
			result++;
		} else if (pq.size() == 1 && !isExistExeedValue){
			result = -1;
		}
		
		return result;
	}

	@Test
	void test1() {
		assertEquals(2, solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
	}
	@Test
	void test2() {
		assertEquals(-1, solution(new int[] { 1, 2, 3, 9, 10, 12 }, 108));
	}
}
