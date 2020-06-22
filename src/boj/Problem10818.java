package boj;

import java.util.Scanner;

/*
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 
둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
*/
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
