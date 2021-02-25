package codility.timecomplexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * PermMissingElem
 * Find the missing element in a given permutation.
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
public class PermMissingElem {
    public int solution(int[] A) {
        boolean[] checks = new boolean[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            checks[A[i] - 1] = true;
        }

        int result = -1;
        for (int i = 0; i < checks.length; i++) {
            if (!checks[i]) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    @Test
    void test1() {
        assertEquals(4, solution(new int[]{2, 3, 1, 5}));
    }
}
