package programmers.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

/**
 * 문자열 내림차순으로 배치하기
 * https://programmers.co.kr/learn/courses/30/lessons/12917?language=java 
 */

public class StringOrderDesc {
    public String solution(String s) {
          
    	char[] array = s.toCharArray();
    	Integer[] intArray = new Integer[array.length];
    	for (int i = 0; i < array.length; i++) {
    		intArray[i] = (int)array[i];
		}
    	Arrays.sort(intArray, Collections.reverseOrder());
    	String answer = "";
    	for (int i = 0; i < intArray.length; i++) {
    		answer += (char)((int)intArray[i]);
		}
        return answer;
    }
    
    @Test
	void test1() {
    	assertEquals("gfedcbZ", solution("Zbcdefg"));
	}
}
