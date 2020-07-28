package baekjoon;
import java.util.Scanner;

// 다음순열 
// https://www.acmicpc.net/problem/10972
public class NextPermutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder stb = new StringBuilder();
		
		int n = sc.nextInt();

		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = sc.nextInt();
		}
		
		int maxIdx = 0;
		
		for (int i = 1; i < n; i++) {
			if ((result[i - 1] < result[i]) && (maxIdx < i )) {
				maxIdx = i;	
			}
		}
		
		if (maxIdx <= 0) { 
			stb.append("-1");
		} else {
			int maxIdx2 = 0; 
			for (int j = maxIdx; j < n; j++) {
				if ((result[maxIdx - 1] < result[j]) && maxIdx2 < j) {
					maxIdx2 = j;
				}
			}
			
			int tmp = result[maxIdx - 1];
			result[maxIdx - 1] = result[maxIdx2];
			result[maxIdx2] = tmp;
			
			maxIdx2 = n - 1;
			while (maxIdx <= maxIdx2) {
				tmp = result[maxIdx];
				result[maxIdx] = result[maxIdx2];
				result[maxIdx2] = tmp;
				maxIdx++;
				maxIdx2--;
			}
			
			for (int i = 0; i < n; i++) {
				stb.append(result[i] + " ");
			}
		}
		System.out.print(stb.toString());
	}
}
