package programmers.level2;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 가장 큰 정사각형 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12905
 * 10-04 : 실패
 */
public class BigSquare {
	public int solution(int[][] board) {
		int rows = board.length;
		int cols = board[0].length;
		
		int[][] newBoard = new int[rows+1][cols+1];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				newBoard[i+1][j+1] = board[i][j];
			}
		}
		
		int answer = 0;
		for (int i = 1; i < newBoard.length; i++) {
			for (int j = 1; j < newBoard[0].length; j++) {
				if (newBoard[i][j] != 0) {
					int result = Math.min(newBoard[i-1][j], newBoard[i][j-1]);
					result = Math.min(result, newBoard[i-1][j-1]);
					newBoard[i][j] = result + 1;
					
					if (answer < result + 1) {
						answer = result + 1;
					}
				}
				
			}
		}
		return answer * answer;
	}

	@Test
	void test1() {
		assertEquals(9, solution(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } }));
	}
}
