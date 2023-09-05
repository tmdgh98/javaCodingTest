package baekjoon.solve;

import java.util.Scanner;

public class TenByTen {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String str = sc.next();
		String print ="";
		for (int i = 0; i < str.length(); i++) {
			print += str.charAt(i);
			if((i!=0&&(i+1)%10==0)||i==str.length()-1) {
				System.out.println(print);
				print="";
			}
		}
	}
}
