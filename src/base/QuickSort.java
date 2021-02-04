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
            while (i < j) {
                while (arr[j] > pivot) j--;
                // 이 부분에서 arr[j-1]에 접근해서 익셉션 발생가능함.
                while (i < j && arr[i] < pivot) i++;

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            //정렬 과정
            quick(left, i - 1, arr);
            quick(i + 1, right, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 10, 7, 9, 2, 6, 8};
        quick(0, arr.length - 1, arr);
        System.out.print(Arrays.toString(arr));
    }

}