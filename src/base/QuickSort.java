package base;

import java.util.Arrays;
import java.util.HashSet;

public class QuickSort {
	// 0. �������� �Ǻ����� �д�
	// 1. ó�� ���� �� �� �Ǻ����� ���� ���� ��ü�� �� �Ѵ� 
	// 2. �� ��  �Ǻ������� ���� ��� �ش� �ڸ��� �����Ѵ�. (�ڸ��� ���� �ε��� ����)
	// 3. ��� �񱳸� ��ģ �� �Ǻ����� ���������� ����� �ε����� �ڸ� ����.
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