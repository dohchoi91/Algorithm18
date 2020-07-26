package programmers.level1.kakao;


/**
 * [카카오 인턴] 키패드 누르기
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 * 
 * [포인트] 
 * 1. 2,5,8,0과 좌표로 인해 맵으로  풀기엔 한계가 존재. 
 * 2. 값을 좌표 변환
 * 3. 이전좌표에 대한 저장 필요
 *
 */
public class KeypadPress {
	
	public static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
        
		//int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		
		int leftPrev = 10;
		int rightPrev = 12;
		hand = hand.substring(0,1).toUpperCase();
		
		for (int i = 0; i < numbers.length; i++) {
			
			int currentValue = numbers[i];
			
			// 0을 11로 치환해서 계산
			currentValue = (currentValue == 0) ? 11 : currentValue;
			
			int row = (currentValue - 1) / 3;
			int col = (currentValue - 1) % 3;
			
			if (col == 0) {
				leftPrev = currentValue;
				answer.append("L");
				
			} else if (col == 2) {
				rightPrev = currentValue;
				answer.append("R");
			} else {
				int prevLeftRow = (leftPrev - 1) / 3;
				int prevLeftCol = (leftPrev - 1) % 3;
				
				int prevRightRow = (rightPrev - 1) / 3;
				int prevRightCol = (rightPrev - 1) % 3;
				
				int diffLeft = Math.abs(prevLeftRow - row) + Math.abs(prevLeftCol - col);
				int diffRight = Math.abs(prevRightRow - row) + Math.abs(prevRightCol - col);
				
				if (diffLeft < diffRight || (diffLeft == diffRight && hand.equals("L")) ) {
					leftPrev = currentValue;
					answer.append("L");
					
				} else {
					rightPrev = currentValue;
					answer.append("R");
				}
			}
		}
        return answer.toString();
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		System.out.println(solution(numbers, "right"));	
		//"LRLLLRLLRRL"

	}

}
