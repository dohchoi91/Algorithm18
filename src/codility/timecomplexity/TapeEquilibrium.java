package codility.timecomplexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TapeEquilibrium
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
public class TapeEquilibrium {
    public int solution(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }

        int aggValue = A[0];
        int min = Math.abs(aggValue - (sum - aggValue));

        for (int i = 1; i < A.length - 1; i++) {
            aggValue += A[i];
            min = Math.min(min, Math.abs(aggValue - (sum - aggValue)));
        }
        return min;
    }

    @Test
    void test1() {
        assertEquals(1, solution(new int[]{3, 1, 2, 4, 3}));
    }

    @Test
    void test2() {
        assertEquals(2000, solution(new int[]{-1000, 1000}));
    }


    @Test
    void test3() {
        assertEquals(0, solution(new int[]{-2, -3, -4, -1}));
    }

}
