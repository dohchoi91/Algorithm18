package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 최솟값 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12941
 */
public class MakeMinNumber {
    public int solution1(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> queueA = new PriorityQueue<>();
        PriorityQueue<Integer> queueB = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : A) {
            queueA.offer(num);
        }
        for (int num : B) {
            queueB.offer(num);
        }

        while (!queueA.isEmpty()) {
            answer += queueA.poll() * queueB.poll();
        }
        return answer;
    }
    public int solution2(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }
        return answer;
    }

    @Test
    void test1() {
        assertEquals(29, solution2(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    }

    @Test
    void test2() {
        assertEquals(10, solution2(new int[]{1, 2}, new int[]{3, 4}));
    }

}
