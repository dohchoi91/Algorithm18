package programmers.level2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.jupiter.api.Test;

/**
 * 구명보트
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 * [포인트]
 * 1. 가장 작은 수와 가장 적합한 가장 큰 수를 세트로 처리
 * 2. 가장 용이한 자료구조 : Deque
 */
public class RescueBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int w : people) {
        	deque.add(w);
		}
        
        while(!deque.isEmpty()) {
        	int first = deque.pollFirst();
        	answer++;
        	while(!deque.isEmpty()) {
        		int last = deque.pollLast();
        		answer++;
        		if (last <= limit - first) {
        			answer--;
        			break;
        		}
        	}
        }
        return answer;
    }
	
	
	@Test
	void test1() {
		assertEquals(3, solution(new int[] {70, 50, 80, 50}, 100));
	}
	@Test
	void test2() {
		assertEquals(3, solution(new int[] {30, 30, 50, 50, 60, 60}, 100));
	}
}
