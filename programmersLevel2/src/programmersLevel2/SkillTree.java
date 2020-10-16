package programmersLevel2;

public class SkillTree {
	class Solution {
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        char[] tree = skill.toCharArray();
	        char[] trees;
	        for (int i = 0; i < skill_trees.length; i++) {
				trees = skill_trees[i].toCharArray();
				answer += boo(tree,trees);
			}
	        return answer;
	    }
	    
	    public int boo(char[] tree,char[] trees) {
	    	boolean bo=true;
	    	int tru=0;
	    	for (int i = 0; i < trees.length; i++) {
				for (int j = 0; j < tree.length; j++) {
					if(trees[i]==tree[j]) {
						if(trees[i]==tree[tru]) {
							tru++;
						}else {
							bo = false;
						}
						break;
					}
				}
				if(bo==false) {
					break;
				}
			}
	    	return bo?1:0;
	    }
	}

}
