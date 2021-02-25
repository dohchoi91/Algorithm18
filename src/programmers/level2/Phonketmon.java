package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 폰켓몬
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Phonketmon {
    public int solution1(int[] nums) {
        int answer = 0;
        int count = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Integer num : map.keySet()) {
            answer++;
            count--;
            if (count == 0) {
                break;
            }
        }
        return answer;
    }

    public int solution2(int[] nums) {
        int count = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        return Math.min(count, set.size());
    }

    @Test
    void test1() {
        assertEquals(2, solution2(new int[]{3, 1, 2, 3}));
    }

    @Test
    void test2() {
        assertEquals(3, solution2(new int[]{3, 3, 3, 2, 2, 4}));
    }

    @Test
    void test3() {
        assertEquals(2, solution2(new int[]{3, 3, 3, 2, 2, 2}));
    }
}
