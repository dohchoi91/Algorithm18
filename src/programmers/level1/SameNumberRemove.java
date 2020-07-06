package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 같은 숫자는 싫어
 * https://programmers.co.kr/learn/courses/30/lessons/12906?language=java
 * [Point]
 * 1. Set 자료구조 사용불가
 * 2. 리턴 타입이 int[]으로 인하여 추가적으로 변환
 */

public class SameNumberRemove {
	public static int[] solution(int[] arr) {
        
        List<Integer> resList = new ArrayList<>();
        int prev = -1;
        
        for (int i = 0; i < arr.length; i++) {
        	if (prev != arr[i]) {
        		resList.add(arr[i]);	
        	}
        	prev = arr[i];
		}
        
        int[] answer = new int[resList.size()];
        
        for (int i = 0; i < resList.size(); i++) {
        	answer[i] = resList.get(i);
		}
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] param = {4,4,4,3,3};
		int[] result = solution(param);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	}

}
