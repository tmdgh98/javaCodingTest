package programmersLevel2;

import java.util.Arrays;
import java.util.Comparator;

public class SortFilename {
	public String[] solution(String[] files) {
        
        
        Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String head1 = head(o1).toUpperCase();
				String head2 = head(o2).toUpperCase();
				if(head1.equals(head2)) {
					return Integer.compare(Integer.parseInt(number(o1)),Integer.parseInt(number(o2)));
				}
				else {
					return head1.compareTo(head2);
				}
			}
        	
		});
        return files;
    }
	
	private String head(String file) {
		String head = "";
		for(int i=0; i<file.length(); i++) {
			char ch = file.charAt(i);
			if(ch>='0'&&ch<='9') {
				break;
			}else {
				head += ch;
			}
		}
		return head;
	}
	private String number(String file) {
		String head = head(file);
		file = file.replace(head, "");
		String number = "";
		for(int i=0; i<file.length(); i++) {
			char ch = file.charAt(i);
			if(ch<'0'||ch>'9') {
				break;
			}else {
				number += ch;
			}
		}
		return number;
	}
}
