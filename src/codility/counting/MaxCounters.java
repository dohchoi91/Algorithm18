package codility.counting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * MaxCounters
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 */
public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int max = 0;
        int min = 0;
        for (int index : A) {
            if (index - 1 == N) {
                min = max;
            } else {
                if (result[index - 1] < min) {
                    result[index - 1] = min;
                }
                result[index - 1]++;
                max = Math.max(max, result[index - 1]);
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(result[i], min);
        }

        return result;
    }

    @Test
    void test1() {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }
    @Test
    void test2() {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution(5, new int[]{1, 3, 4, 4, 6, 1, 4, 4}));
    }
}
