package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 문자열을 정수로 바꾸기
 * https://programmers.co.kr/learn/courses/30/lessons/12925?language=java
 */
public class StringToInt {
    public int solution(String s) {
        return Integer.parseInt(s);        
    }
    
    @Test
	void test1() {
    	assertEquals(1234, solution("+1234"));
	}
}
