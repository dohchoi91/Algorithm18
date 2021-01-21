package programmers.level1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// 제곱근 판별
// https://programmers.co.kr/learn/courses/30/lessons/12934
public class IsSquareRoot {
    public long solution(long n) {
    	double value = Math.sqrt(n);
    	// 소수점 판단은 엄청 단순하게 가능
    	long answer = (value == (int)value) ? (long)Math.pow(value + 1, 2) : -1;
        return answer;
    }

	@Test
	void test1() {
		assertEquals(144, solution(121));
	}
	
	@Test
	void test2() {
		assertEquals(-1, solution(3));
	}
}
