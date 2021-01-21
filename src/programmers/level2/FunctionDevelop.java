package programmers.level2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

/**
 * 기능개발 
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * [포인트]
 * 1. 잔여일에 정확한 계산 필요. (형변환 주의)
 */
public class FunctionDevelop {
	public int[] solution(int[] progresses, int[] speeds) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < progresses.length; i++) {
			double remain = (double)(100 - progresses[i]) / speeds[i];
			int remainDay=  remain > (int)remain ? (int)remain + 1 : (int)remain;
			queue.add(remainDay);
		}
		
		int prev = -1;
		
		List<Integer> resList = new ArrayList<>();
		while(!queue.isEmpty()) {
			int value = queue.poll();
			if (prev < value) {
				prev = value;
				resList.add(1);
				
			} else {
				int lastIndex = resList.size() - 1;
				resList.set(lastIndex, resList.get(lastIndex) + 1);
			}
		}
		
		int[] answer = new int[resList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = resList.get(i);
		}
		
		return answer;
	}
	
	

	@Test
	void test1() {
		assertArrayEquals(new int[] { 2, 1 }, solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 }));
	}
}
