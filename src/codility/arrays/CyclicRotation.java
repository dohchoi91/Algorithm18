package codility.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * CyclicRotation
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int size = A.length;
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[(i + K) % size] = A[i];
        }
        return result;
    }

    @Test
    void test1() {
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, solution(new int[]{3, 8, 9, 7, 6}, 3));
    }
}
