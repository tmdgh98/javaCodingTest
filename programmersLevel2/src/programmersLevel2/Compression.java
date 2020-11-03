package programmersLevel2;

import java.util.ArrayList;
import java.util.List;

public class Compression {
	private List<String> list = new ArrayList<String>();
	private String str;
	
	public Compression() {
		for (int i = 0; i < 26; i++) {
        	char alpha = (char)('A'+i);
			list.add(Character.toString(alpha));
		}
	}
	
	public int[] solution(String msg) {
        str = msg;
        List<Integer> ans = new ArrayList<Integer>();
        while(str.length()>0) {
        	ans.add(search());
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++) {
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
	
	private int search() {
		int se = 0;
		for (int i = list.size()-1; i >= 0 ; i--) {
			if(list.get(i).charAt(0)==str.charAt(0)) {
				if(discrimination(list.get(i))) {
					se = i+1;
					str = str.replaceFirst(list.get(i), "");
					if(str.length()!=0)
					list.add(list.get(i)+str.charAt(0));
					break;
				}
			}
		}
		
		return se;
	}
	
	private boolean discrimination(String listStr) {
		if(listStr.length()>str.length()) {
			return false;
		}
		for (int i = 1; i < listStr.length(); i++) {
			if(listStr.charAt(i)!=str.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
