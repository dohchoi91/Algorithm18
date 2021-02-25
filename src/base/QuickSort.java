package base;

import java.util.Arrays;

// https://ko.wikipedia.org/wiki/%ED%80%B5_%EC%A0%95%EB%A0%AC
public class QuickSort {
    static void quick(int left, int right, int[] arr) {
        int i, j, pivot, tmp;
        if (left < right) {
            i = left;
            j = right;
            pivot = arr[(left + right) / 2];

            //분할 과정
            // pivot 값의 정렬될 위치와 위치를 기준으로 좌(작은값), 우(큰 캆)로 분류시킨다.
            while (i < j) {
                while (arr[j] > pivot) j--;
                // 이 부분에서 arr[j-1]에 접근해서 익셉션 발생가능함.
                while (i < j && arr[i] < pivot) i++;

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }

//            if (left == 0 && right == arr.length - 1) {
//                System.out.println(Arrays.toString(arr));
//            }

            //정렬 과정
            quick(left, i - 1, arr);
            quick(i + 1, right, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 6, 2, 1, 4};
        quick(0, arr.length - 1, arr);
        System.out.print(Arrays.toString(arr));
    }

}