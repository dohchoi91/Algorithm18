package programmers.level1.kakao;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * 2019 KAKAO BLIND RECRUITMENT 실패율
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 * [포인트] 
 * 1. 명시적 형변환(double)
 * 2. 정렬 기준의 정의 
 * 3. 정렬 기준이 두 개 이상일 경우 별도의 클래스를 만들고 Comparator를 구현하는 방법도 괜찮음.
 */
public class FailPercent {
	
	void quick(int left, int right, double[] values, int[] indexes) {
        int pivot = left;
        int j = pivot;
        double valueTemp;
        int idxTemp; 
        
        if (left < right) {
            for (int i = left + 1; i <= right; i++) {
                //swap
                if (values[i] > values[pivot] || 
                	(values[i] == values[pivot] &&  indexes[i] < indexes[pivot])) {
                    
                	j++;
                    valueTemp = values[j];
                    values[j] = values[i];
                    values[i] = valueTemp;
                    
                    idxTemp = indexes[j];
                    indexes[j] = indexes[i];
                    indexes[i] = idxTemp;
                }
            }
            valueTemp = values[left];
            values[left] = values[j];
            values[j] = valueTemp;
            
            idxTemp = indexes[left];
            indexes[left] = indexes[j];
            indexes[j] = idxTemp;
            
            pivot = j;
            quick(left, pivot - 1, values, indexes);
            quick(pivot + 1, right, values, indexes);
        }
    }
	
    public int[] solution(int N, int[] stages) {
    	int[] passCounts = new int[N+1];
    	int[] answer = new int[N];
    	
    	for (int i = 0; i < answer.length; i++) {
    		answer[i] = i+1;
		}
    	
    	for (int i = 0; i < stages.length; i++) {
    		passCounts[stages[i] - 1]++;
		}
    	
    	int totalUsers = stages.length;
    	int accumalateUsers = 0;
    	double[] values = new double[N];
    	for (int i = 0; i < passCounts.length - 1; i++) {
			values[i] = (double)passCounts[i] / (double)(totalUsers - accumalateUsers);
			accumalateUsers += 	passCounts[i];
		}
    	
    	quick(0, N-1, values, answer);
        return answer;
    }
    
    @Test
    void main () {
    	int[] stages1 = {2,1,2,6,2,4,3,3};
    	int[] stages2 = {4,4,4,4,4};
    	
    	assertArrayEquals(new int [] {3,4,2,1,5}, solution(5, stages1));
    	assertArrayEquals(new int [] {4,1,2,3}, solution(4,	stages2));
    }
}
