package programmers.level1;
/*
 * 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 * 
 * [포인트] 
 * 1. 절대 이중 for문을 쓸 수 없다 -> 시간 초과
 * 2. participant - completion = 1 => 반드시 1명은 완주하지 못하였다. (답은 하나만 존재.)
 * 3. for문을 두 번에 나눠 사용하여 map를 구성 및 검색한다.
 * 4. 동명이인 : Map에 value 값을 Integer로 만들게 한 이유 
 *  
 */
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
       
        String answer = "";
        
        Map<String, Integer> completionMap = new HashMap<String, Integer>();
        
        for (int i = 0; i < completion.length; i++) {
            int count = 1;
            if (completionMap.get(completion[i]) != null) {
                count = completionMap.get(completion[i]) + 1;
            }
            completionMap.put(completion[i], count);
        }
         
        for (int i = 0; i < participant.length; i++) {
            Integer completionValue = completionMap.get(participant[i]);
            if (completionValue != null && completionValue > 0) {
                completionMap.put(participant[i], completionValue - 1);
            } else {
                answer = participant[i];
                break;
            }
        }
       
        return answer;
    }
}
