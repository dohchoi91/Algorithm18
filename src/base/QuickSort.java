package base;

import java.util.Arrays;
import java.util.HashSet;

public class QuickSort {
	// 0. 좌측값을 피봇으로 둔다
	// 1. 처음 시작 할 때 피봇값을 기준 으로 전체를 비교 한다 
	// 2. 비교 시  피봇값보다 작을 경우 해당 자리를 스왑한다. (자리에 대한 인덱스 증진)
	// 3. 모든 비교를 마친 후 피봇값을 마지막으로 변경된 인덱스로 자리 변경.
	static void quick(int left, int right, int[] arr) {
        int pivot = left;
        int j = pivot;
        int temp;

        if (left < right) {
            for (int i = left + 1; i <= right; i++) {
                //swap
                if (arr[i] < arr[pivot]) {
                    j++;
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            temp = arr[left];
            arr[left] = arr[j];
            arr[j] = temp;

            pivot = j;
            quick(left, pivot - 1, arr);
            quick(pivot + 1, right, arr);
        }
    }

	public static void main(String[] args) {
		
		int[] arr = { 3, 1, 4, 5, 7, 9, 2, 6, 8 };
		HashSet set = new HashSet<>(Arrays.asList(arr));
				
		quick(0, 8, arr);
		
		for (int i = 0; i < 9; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}