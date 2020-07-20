package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 나누어 떨어지는 숫자 배열
 * https://programmers.co.kr/learn/courses/30/lessons/12910?language=java
 * [포인트] 
 * 1. 정렬 기준 파악
 * 2. Comparator를 구현
 */
public class IntegerArrayDivide {

    public int[] solution(int[] arr, int divisor) {
    	List<Integer> resList = new ArrayList<Integer>();
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] % divisor == 0) {
    			resList.add(arr[i]);
    		}
		}
    	if (resList.size() == 0) {
    		resList.add(-1);
    	} else {
    		Collections.sort(resList);	
    	}
    	
        int[] answer = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
        	answer[i] = resList.get(i);
		}
        return answer;
	}

	@Test
	void test1() {
		assertArrayEquals(new int[] { 5, 10 }, solution(new int[] { 5, 9, 7, 10}, 5));
	}
	@Test
	void test2() {
		assertArrayEquals(new int[] { 1, 2, 3, 36 }, solution(new int[] { 2, 36, 1, 3 }, 1));

	}
}
