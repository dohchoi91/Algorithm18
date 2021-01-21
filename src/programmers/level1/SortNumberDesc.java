package programmers.level1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

// 정수 내림차순으로 배치하기
// https://programmers.co.kr/learn/courses/30/lessons/12933
public class SortNumberDesc {
    public long solution(long n) {
    	// 시도 1
        String[] result = String.valueOf(n).split("");
        Arrays.sort(result, Collections.reverseOrder());
		StringBuilder stb = new StringBuilder();
		
		for (String numStr : result) {
			stb.append(numStr);
		}
		//return Long.parseLong(stb.toString());
		
		// 시도 2
		char[] chars = String.valueOf(n).toCharArray();
		Arrays.sort(chars);
		stb = new StringBuilder(String.valueOf(chars));
		return Long.parseLong(stb.reverse().toString()); 
		
    }
    
	@Test
	void test1() {
		assertEquals(873211, solution(118372));
	}
    	
}
