package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
 * 하샤드 수
 * https://programmers.co.kr/learn/courses/30/lessons/12947
 */
public class HashadNumber {
    public boolean solution(int x) {
    	int placeSum = 0;
    	int temp = x;
    	while(temp > 0) {
    		placeSum += temp % 10;
    		temp /= 10;
    	}
        return x % placeSum == 0;
    }
	
	@Test
	void test1() {
		assertEquals(true, solution(10));
	}
	
	@Test
	void test2() {
		assertEquals(false, solution(11));
	}
	@Test
	void test3() {
		assertEquals(true, solution(12));
	}
	
	@Test
	void test4() {
		assertEquals(false, solution(13));
	}
}
