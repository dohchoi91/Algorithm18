package boj;
import java.util.Scanner;

// 다음 순열 문제 : https://www.acmicpc.net/problem/10972
public class Problem10972 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder stb = new StringBuilder();
		
		// 입력 개수가 주어지면 굳이 Line으로 안받아도 된다 -> Line으로 받고 split하는게 더 시간 걸림
		int n = sc.nextInt();

		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = sc.nextInt();
		}
		
		int maxIdx = 0;
		
		// A[i-1] < A[i]가 성립되느 가장 큰 i (= 가장 오른쪽)
		for (int i = 1; i < n; i++) {
			if ((result[i - 1] < result[i]) && (maxIdx < i )) {
				maxIdx = i;	
			}
		}
		
		if (maxIdx <= 0) { // 다음순열 존재 X
			stb.append("-1");
		} else {
			int maxIdx2 = 0; 
			for (int j = maxIdx; j < n; j++) {
				// j >= maxIdx 이면서 A[j] > A[maxIdx - 1]을 만족하는 가장 큰 j
				if ((result[maxIdx - 1] < result[j]) && maxIdx2 < j) {
					maxIdx2 = j;
				}
			}
			
			// A[maxIdx - 1] A[maxIdx2] 자리 Swap
			int tmp = result[maxIdx - 1];
			result[maxIdx - 1] = result[maxIdx2];
			result[maxIdx2] = tmp;
			
			// A[maxIdx] 부터 끝까지 revese -> 양 첫단과 끝단의 자리 교체 
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
