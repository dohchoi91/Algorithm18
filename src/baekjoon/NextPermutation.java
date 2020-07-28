package baekjoon;
import java.util.Scanner;

// ���� ���� ���� : https://www.acmicpc.net/problem/10972
public class Problem10972 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder stb = new StringBuilder();
		
		// �Է� ������ �־����� ���� Line���� �ȹ޾Ƶ� �ȴ� -> Line���� �ް� split�ϴ°� �� �ð� �ɸ�
		int n = sc.nextInt();

		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = sc.nextInt();
		}
		
		int maxIdx = 0;
		
		// A[i-1] < A[i]�� �����Ǵ� ���� ū i (= ���� ������)
		for (int i = 1; i < n; i++) {
			if ((result[i - 1] < result[i]) && (maxIdx < i )) {
				maxIdx = i;	
			}
		}
		
		if (maxIdx <= 0) { // �������� ���� X
			stb.append("-1");
		} else {
			int maxIdx2 = 0; 
			for (int j = maxIdx; j < n; j++) {
				// j >= maxIdx �̸鼭 A[j] > A[maxIdx - 1]�� �����ϴ� ���� ū j
				if ((result[maxIdx - 1] < result[j]) && maxIdx2 < j) {
					maxIdx2 = j;
				}
			}
			
			// A[maxIdx - 1] A[maxIdx2] �ڸ� Swap
			int tmp = result[maxIdx - 1];
			result[maxIdx - 1] = result[maxIdx2];
			result[maxIdx2] = tmp;
			
			// A[maxIdx] ���� ������ revese -> �� ù�ܰ� ������ �ڸ� ��ü 
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
