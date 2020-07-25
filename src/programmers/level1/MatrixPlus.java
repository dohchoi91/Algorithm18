package programmers.level1;

/*
 * 행렬의 덧셈
 * https://programmers.co.kr/learn/courses/30/lessons/12950
 */
import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class MatrixPlus {
    public int[][] solution(int[][] arr1, int[][] arr2) {
    	
    	int row = arr1.length;
    	int col = arr1[0].length;
    	int[][] answer = new int[row][col];
    	
    	for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				answer[i][j] = 	arr1[i][j] + arr2[i][j];
			}
		}
        
        return answer;
    }
    
	@Test
	void test1() {
		 assertArrayEquals(new int[][] {{4},{6}}, solution(new int[][] {{1},{2}}, new int[][]{{3},{4}}));
	}
   
}
