package inflearn.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// 세 수의 합
// 숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때 numbers 배열에 들어있는 수 세 개를 더해서 target 숫자를 만들 수 있는 인덱스를 찾는 함수를 작성하라.
// numbers는 중복이 X, target을 만들 수 있는 조합 한 개 뿐이다.
// 예) numbers = [2, 3, 5, 7] target = 10, 10을 만들 수 있는 2, 3, 5의 인덱스인 0, 1, 2를 배열로 리턴해야 한다.
public class SumOfThreeNumbers {

    static int pick;
    static int[] nums;
    static boolean[] checks;
    static boolean isFind;

    public void comb(int count, int[] numbers, int target) {
        if (count == pick) {
            int sum = Arrays.stream(nums).sum();
            isFind = (sum == target);
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (!checks[i]) {
                    checks[i] = true;
                    nums[count] = numbers[i];
                    comb(count + 1, numbers, target);
                    checks[i] = false;
                }
                if (isFind) {
                    break;
                }
            }
        }
    }

    // 시간 복잡도 :
    // 공간 복잡도 :
    public int[] solution1(int[] numbers, int target) {
        pick = 3;
        checks = new boolean[numbers.length];
        isFind = false;
        nums = new int[]{0, 0, 0};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        comb(0, numbers, target);

        int[] answer = new int[pick];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = map.get(nums[i]);
        }
        return answer.length > 0 ? answer : null;
    }

    // 시간 복잡도 : O(n^3)
    // 공간 복잡도 : O(n)
    public int[] solution2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                for (int k = 0; k < numbers.length; k++) {
                    int last = target - numbers[i] - numbers[j];
                    if (map.get(last) != null) {
                        return new int[]{i, j, map.get(last)};
                    }
                }
            }
        }

        return null;
    }

    @Test
    @DisplayName("재귀함수를 이용한 솔루션 메서드 테스트")
    public void solutionTest() {
        assertArrayEquals(new int[]{0, 1, 2}, solution1(new int[]{2, 3, 5, 7, 8, 10}, 10));
        assertArrayEquals(new int[]{1, 2, 3}, solution1(new int[]{2, 3, 5, 7}, 15));
    }

    @Test
    @DisplayName("3중 for문을 이용한 솔루션 메서드 테스트")
    public void solutionTest2() {
        assertArrayEquals(new int[]{0, 1, 2}, solution2(new int[]{2, 3, 5, 7}, 10));
        assertArrayEquals(new int[]{1, 2, 3}, solution2(new int[]{2, 3, 5, 7}, 15));
    }
}
