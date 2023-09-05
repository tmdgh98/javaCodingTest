package baekjoon.solve;

import java.util.Scanner;

public class Croatian {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String str = sc.next();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			switch(a) {
				case 'c':
					if(i<str.length()-1&&str.substring(i, i+2).equals("c=")) continue;
					if(i<str.length()-1&&str.substring(i, i+2).equals("c-")) continue;
					count++;
					break;
				case 'd':
					if(i<str.length()-2&&str.substring(i, i+3).equals("dz=")) continue;
					if(i<str.length()-1&&str.substring(i, i+2).equals("d-")) continue;
					count++;
					break;
				case 'l':
					if(i<str.length()-1&&str.substring(i, i+2).equals("lj")) continue;
					count++;
					break;
				case 'n':
					if(i<str.length()-1&&str.substring(i, i+2).equals("nj")) continue;
					count++;
					break;
				case 's':
					if(i<str.length()-1&&str.substring(i, i+2).equals("s=")) continue;
					count++;
					break;
				case 'z':
					if(i<str.length()-1&&str.substring(i, i+2).equals("z=")) continue;
					count++;
					break;
				default: count++;
			}
		}
		
		System.out.println(count);
	}
}
