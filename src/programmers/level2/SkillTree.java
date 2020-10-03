package programmers.level2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 스킬트리 (Summer/Winter Coding(~2018))
 * https://programmers.co.kr/learn/courses/30/lessons/49993?language=java
 */
public class SkillTree {

	public int solution(String skill, String[] skill_trees) {
		
		int answer = 0;
		boolean[] targets = new boolean[26];
		
		List<Character> skillList = new ArrayList<>();
		for (char s : skill.toCharArray()) {
			int index = (int)s % 65;
			targets[index] = true;
			skillList.add(s);
		}
		
		for (int i = 0; i < skill_trees.length; i++) {
			int skillIdx = 0;
			boolean isAvailable = true;
			
			for (char s : skill_trees[i].toCharArray()) {
				int index = (int)s % 65;
				if (targets[index]) { // 선행 스킬 확인  대상인 경우
					if (s == skillList.get(skillIdx)) {
						skillIdx++;
					} else  {
						isAvailable = false;
						break;
					}
				}
			}
			if (isAvailable) {
				answer++;
			}
		}
		return answer;
	}

	@Test
	void test1() {
		assertEquals(2, solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
	}
}
