package backjun.solve;

import java.util.Scanner;

public class WordStudy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		str = str.toUpperCase();
		int[] alpha = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i)-'A';
			alpha[index]++;
		}
		int max=0;
		int maxi = 0;
		boolean top = false;
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i]>max) {
				max = alpha[i];
				maxi = i;
				top = true;
			}else if(alpha[i]==max) {
				top = false;
			}
		}
		if(top) {
			char a = (char) ('A'+maxi);
			System.out.println(a);
		}else {
			System.out.println('?');
		}
		
	}
}
