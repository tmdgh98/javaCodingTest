package backjun.solve;

import java.util.Scanner;

public class StringIteration {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				for (int j2 = 0; j2 < num; j2++) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
