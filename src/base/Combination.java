package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 조합 (Combination)
 * n개의 원소 중 r개의 원소를 꺼내는 경우의 수
 * 순서가 유효하지 않기 때문에 중복을 허용하지 않음 (순열은 순서가 유효하므로 중복 허용)
 * 경우의 수 : nPr / r! = n! / r! * (n-r)!
 * 표기법 : nCr
 * 참고2 : https://codevang.tistory.com/298
 * 참고2 : https://bcp0109.tistory.com/15
 */
public class Combination {

    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];


        List<String> arrList = new ArrayList<>();
        arrList.add("1");
        arrList.add("2");
        arrList.add("3");

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            reculsion(arrList, result, 0, arrList.size(), i);
            System.out.println("================================");
            comb_backtracking(arr, output, visited, 0, i);
            System.out.println("================================");
        }
    }

    /**
     * 조합 구하기
     * @param arr    : 기준 리스트
     * @param result : 결과를 담아줄 리스트
     * @param index  : 반복문 시작 인덱스
     * @param n      : 전체 갯수
     * @param r      : 뽑을 갯수
     */
    private static void reculsion(List<String> arr, List<String> result, int index, int n, int r) {
        if (r == 0) {
            System.out.println(result.toString());
        } else {
            for (int i = index; i < n; i++) {
                result.add(arr.get(i));
                reculsion(arr, result, i + 1, n, r - 1);
                result.remove(result.size() - 1);
            }
        }
    }

    static void comb_backtracking(int[] arr, int[] output, boolean[] visited, int start, int r) {
        if (r == 0) {
            System.out.println(Arrays.toString(output));
//            for (int i = 0; i < arr.length; i++) {
//                if (visited[i]) {
//                    System.out.print(arr[i] + " ");
//                }
//            }
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                output[start] = arr[i];
                comb_backtracking(arr, output, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}
