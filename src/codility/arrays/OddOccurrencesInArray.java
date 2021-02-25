package codility.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * OddOccurrencesInArray
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */
public class OddOccurrencesInArray {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int result = -1;
        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                result = key;
                break;
            }
        }
        return result;
    }
    public int solution2(int[] A) {
        Arrays.sort(A);
        int result = A[0];
        int cnt = 1;
        for (int i = 1; i < A.length; i++) {
            if (result == A[i]) {
                cnt++;
            } else {
                if (cnt % 2 == 1) {
                    break;
                }
                cnt = 1;
                result = A[i];
            }

        }
        return result;
    }
    @Test
    void test1() {
        assertEquals(7, solution2(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }
}
