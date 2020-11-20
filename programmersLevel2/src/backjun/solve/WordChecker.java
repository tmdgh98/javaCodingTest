package backjun.solve;

import java.util.Scanner;

public class WordChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			boolean[] alpha = new boolean['z'-'a'+1];
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				if(alpha[ch-'a']==false) {
					if(j<str.length()-1&&ch==str.charAt(j+1)) continue;
					alpha[ch-'a']=true;
				}else {
					break;
				}
				if(str.length()-1==j) count++;
			}
		}
		
		System.out.println(count);
	}
}
