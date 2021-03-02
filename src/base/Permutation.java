package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 순열 (Permutation)
 * n개의 원소 중 r개의 원소를 꺼내는 경우의 수
 * 순서가 유효하기 때문에 원소의 중복을 허용함 (조합은 순서가 유효하지 않아 중복 불허)
 * 경우의 수 : n! / (n-r)! 의 갯수를 가짐
 * 표기법  : nPr
 *
 * 참고1 : https://bcp0109.tistory.com/14
 * 참고2 : https://codevang.tistory.com/297
 *
 */

public class Permutation {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        perm(arr, output, visited, 0, n, 3);
        System.out.println();
        permutation(arr, 0, n, 3);
        System.out.println();

        List<Integer> arrList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        reculsion(arrList, resultList, arrList.size(), 3);
    }

    // 사전순으로 순열 구하기
    // 사용 예시: perm(arr, output, visited, 0, n, 3);
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(output));
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output[depth] = arr[i];
                    perm(arr, output, visited, depth + 1, n, r);
                    visited[i] = false;
                }
            }
        }
    }

    // 순열 구하기 (정렬 순서를 보장하지는 않음)
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = depth; i < n; i++) {
                swap(arr, depth, i);
                permutation(arr, depth + 1, n, r);
                swap(arr, depth, i);
            }
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void reculsion(List<Integer> arr, List<Integer> result, int n, int r) {
        if (r == 0) {
            System.out.println(result.toString());
        } else {
            for (int i = 0; i < n; i++) {
                result.add(arr.remove(i));
                reculsion(arr, result, n - 1, r - 1);
                arr.add(i, result.remove(result.size() - 1));
            }
        }
    }
}
