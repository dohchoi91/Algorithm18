package codility.counting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * PermCheck
 * Check whether array A is a permutation.
 * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 */
public class PermCheck {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if ((i + 1) != A[i]) {
                return 0;
            }
        }
        return 1;
    }

    @Test
    void test1() {
        assertEquals(1, solution(new int[]{4, 1, 3, 2}));
        assertEquals(0, solution(new int[]{4, 1, 3}));
    }

}
