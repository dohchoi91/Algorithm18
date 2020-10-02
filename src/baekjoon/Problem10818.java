package baekjoon;

import java.util.Scanner;

public class Problem10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] numList = new int[num];
		
		for (int i = 0; i < num; i++) {
			numList[i] = sc.nextInt();
		}

		int max = -1000000, min = 1000000;
		
		for (int i = 0; i < numList.length; i++) {
			int value = numList[i];
			max = (value > max) ? value : max;
			min = (value < min) ? value : min;
		}
		System.out.println(min + " " + max);
	}

}
